package kae.demo.marketplacecms.author.infrastructure.persistence;

import kae.demo.marketplacecms.author.domain.model.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/** */
@Repository
public interface DocumentRepository extends MongoRepository<Document, String> {

  Optional<Document> findByName(String name);
}
