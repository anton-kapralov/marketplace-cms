package kae.demo.marketplacecms.author.application;

import kae.demo.marketplacecms.author.application.representation.CreateBannerCommand;
import kae.demo.marketplacecms.author.domain.model.Document;
import kae.demo.marketplacecms.author.infrastructure.persistence.DocumentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/** */
@Service
public class DocumentService {

  private final DocumentRepository repository;

  public DocumentService(DocumentRepository repository) {
    this.repository = repository;
  }

  public List<Document> getAll() {
    return repository.findAll();
  }

  public Document createBanner(CreateBannerCommand command) {
    return repository.save(command.asDocument());
  }

  public Optional<Document> findById(String id) {
    return repository.findById(id);
  }
}
