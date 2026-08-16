package tech.chillo.sa_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.chillo.sa_backend.enums.TypeSentiment;
import tech.chillo.sa_backend.model.Sentiment;

@Repository
public interface SentimentRepository extends JpaRepository<Sentiment, Integer> {

    Iterable<Sentiment> findByType(TypeSentiment type);

}
