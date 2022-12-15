package br.com.kangu.mcep.controllers;

import br.com.kangu.mcep.exception.BadCepFormationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/CEP")
public class CEPController {

    @GetMapping(value="/{CEP}")
    public String findById(@PathVariable String CEP) throws Exception {

        if (CEP.length() != 8) {
            throw new BadCepFormationException("Cep tem de tem apenas 8 caracteres");
        }

        String url = "https://brasilapi.com.br/api/cep/v2/" + CEP;
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        return result;

    }

}
