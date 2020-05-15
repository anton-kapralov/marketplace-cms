package kae.demo.marketplacecms.author.infrastructure.persistence;

import kae.demo.marketplacecms.author.domain.model.Document;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/** */
@Repository
public interface DocumentRepository extends ReactiveMongoRepository<Document, String> {

  Mono<Document> findByName(String name);
}
