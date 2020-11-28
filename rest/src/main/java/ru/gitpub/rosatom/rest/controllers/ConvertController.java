package ru.gitpub.rosatom.rest.controllers;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.gitpub.rosatom.services.SpeechConverter;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@RestController
public class ConvertController {

    private final SpeechConverter speechConverter;

    public ConvertController(SpeechConverter speechConverter) {
        this.speechConverter = speechConverter;
    }

    @PostMapping(value = "/api/speech/convert", consumes = MULTIPART_FORM_DATA_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> convert(@RequestParam MultipartFile speech) throws IOException {
        return ResponseEntity.ok(speechConverter.convert(speech.getInputStream()));
    }
}
