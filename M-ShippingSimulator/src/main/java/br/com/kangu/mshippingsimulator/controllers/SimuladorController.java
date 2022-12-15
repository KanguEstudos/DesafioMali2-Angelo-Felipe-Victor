package br.com.kangu.mshippingsimulator.controllers;

import okhttp3.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(value = "/simulador")
public class SimuladorController {

    @GetMapping
    public String SimulaFrete() throws IOException {

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\r\n  \"cepOrigem\": \"01010010\",\r\n  \"cepDestino\": \"13472500\",\r\n  \"vlrMerc\": \"20.50\",\r\n  \"pesoMerc\": \"0.040\",\r\n  \"volumes\": [\r\n    {\r\n      \"peso\": \"0.040\",\r\n      \"altura\": \"2\",\r\n      \"largura\": \"11\",\r\n      \"comprimento\": \"16\"\r\n    }\r\n  ],\r\n   \"servicos\": [\r\n    \"E\", \"X\", \"R\", \"M\"\r\n  ]\r\n}");
        Request request = new Request.Builder()
                .url("https://portal.kangu.com.br/tms/transporte/simular")
                .method("POST", body)
                .addHeader("token", "64845971de3d90c6f5f3e97eabe0e12b8500752fb695283b7c5466c1221e7d16")
                .addHeader("Content-Type", "application/json")
                .addHeader("Cookie", "KANGUSESSID=3kl96b3muuk38r37ia6d2lu3c5")
                .build();
        Response response = client.newCall(request).execute();

        return response.body().string();
    }


}
