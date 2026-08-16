package tech.chillo.sa_backend.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tech.chillo.sa_backend.enums.TypeSentiment;
import tech.chillo.sa_backend.model.Client;
import tech.chillo.sa_backend.model.Sentiment;
import tech.chillo.sa_backend.repository.SentimentRepository;

@Service
@RequiredArgsConstructor
public class SentimentService {

    private final ClientService clientService;
    private final SentimentRepository sentimentRepository;

    public void creerSentiment(Sentiment sentiment) {
        Client client = clientService.readOrCreate(sentiment.getClient());
        sentiment.setClient(client);
        if (sentiment.getTexte().contains("pas")) {
            sentiment.setType(TypeSentiment.NEGATIF);
        } else {
            sentiment.setType(TypeSentiment.POSITIF);
        }
        sentimentRepository.save(sentiment);
    }

    public Iterable<Sentiment> getAllSentiment(TypeSentiment type) {
        if (type == null) {
            return sentimentRepository.findAll();
        } else {
            return sentimentRepository.findByType(type);
        }

    }

    public void deleteSentiment(Integer id) {
        sentimentRepository.deleteById(id);
    }

}
