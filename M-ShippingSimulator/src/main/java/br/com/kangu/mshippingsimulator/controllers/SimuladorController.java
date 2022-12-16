package br.com.kangu.mshippingsimulator.controllers;

import br.com.kangu.mshippingsimulator.entities.Simulation;
import br.com.kangu.mshippingsimulator.repositories.SimulationRepository;
import com.google.gson.Gson;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "/simulador")
public class SimuladorController {

    @Autowired
    private SimulationRepository simulationRepository;

    @GetMapping
    public String SimulaFrete() throws Exception {

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");

        RequestBody body = RequestBody.create(mediaType, "{" +
                                                                    "\"cepOrigem\": \"01010010\"," +
                                                                    "\"cepDestino\": \"13472500\"," +
                                                                    "\"vlrMerc\": \"20.50\"," +
                                                                    "\"pesoMerc\": \"0.040\"," +
                                                                    "\"volumes\": [" +
                                                                        "{" +
                                                                        "\"peso\": \"0.040\"," +
                                                                        "\"altura\": \"2\"," +
                                                                        "\"largura\": \"11\"," +
                                                                        "\"comprimento\": \"16\"" +
                                                                        "}" +
                                                                    "]," +
                                                                    "\"servicos\": [" +
                                                                        "\"E\", \"X\", \"R\", \"M\"" +
                                                                    "]" +
                                                                "}");

        Request request = new Request.Builder()
                .url("https://portal.kangu.com.br/tms/transporte/simular")
                .method("POST", body)
                .addHeader("token", "64845971de3d90c6f5f3e97eabe0e12b8500752fb695283b7c5466c1221e7d16")
                .addHeader("Content-Type", "application/json")
                .build();

        Response response = client.newCall(request).execute();

        JsonParse jsonParse = new JsonParse(response.body().string());
        ArrayList<Simulation> arrayData = jsonParse.gatData();

        for (int i = 0; i < arrayData.size(); i++) {
            simulationRepository.save(arrayData.get(i));
        }

        return new Gson().toJson(arrayData);

    }

}
