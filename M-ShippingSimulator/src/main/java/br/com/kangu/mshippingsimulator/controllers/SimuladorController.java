package br.com.kangu.mshippingsimulator.controllers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import okhttp3.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

@RestController
@RequestMapping(value = "/simulador")
public class SimuladorController {

    @GetMapping
    public String SimulaFrete() throws IOException {

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

        return response.body().string();
    }

    @GetMapping(value = "/teste")
    public void testeJson() throws ParseException {

        String jsonString = "{\n" +
                "    \"Name\": \"crunchify.com\",\n" +
                "    \"Author\": \"App Shah\",\n" +
                "    \"Company List\": [\n" +
                "        \"Compnay: eBay\",\n" +
                "        \"Compnay: Paypal\",\n" +
                "        \"Compnay: Google\"\n" +
                "    ]\n" +
                "}";

        JSONParser parser = new JSONParser();
        Object obj = parser.parse(jsonString);

       // Testes de json parse. FAIL

    }


}
