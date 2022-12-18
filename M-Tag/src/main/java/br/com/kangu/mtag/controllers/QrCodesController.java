package br.com.kangu.mtag.controllers;

import br.com.kangu.mtag.generator.QrCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.awt.image.BufferedImage;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;


@RestController
public class QrCodesController {



    private ResponseEntity<BufferedImage> ok(final BufferedImage bufferedImage) {
        return new ResponseEntity<>(bufferedImage, OK);
    }
}