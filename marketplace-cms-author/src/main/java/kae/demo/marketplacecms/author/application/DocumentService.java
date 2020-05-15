package kae.demo.marketplacecms.author.application;

import kae.demo.marketplacecms.author.application.representation.CreateBannerCommand;
import kae.demo.marketplacecms.author.domain.model.Document;
import kae.demo.marketplacecms.author.infrastructure.persistence.DocumentRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/** */
@Service
public class DocumentService {

  private final DocumentRepository repository;

  public DocumentService(DocumentRepository repository) {
    this.repository = repository;
  }

  public Flux<Document> getAll() {
    return repository.findAll();
  }

  public Mono<Document> createBanner(CreateBannerCommand command) {
    return repository.save(command.asDocument());
  }

  public Mono<Document> findById(String id) {
    return repository.findById(id);
  }
}
