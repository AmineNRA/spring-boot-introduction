package tech.chillo.sa_backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import tech.chillo.sa_backend.enums.TypeSentiment;
import tech.chillo.sa_backend.model.Sentiment;
import tech.chillo.sa_backend.service.SentimentService;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/sentiment")
public class SentimentController {

    private final SentimentService sentimentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void creerSentiment(@RequestBody Sentiment sentiment) {
        sentimentService.creerSentiment(sentiment);
    };

    @GetMapping
    public Iterable<Sentiment> getAllSentiment(@RequestParam(required = false) TypeSentiment type) {
        return sentimentService.getAllSentiment(type);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/{id}")
    public void supprimer(@PathVariable Integer id) {
        sentimentService.deleteSentiment(id);
    }

}
