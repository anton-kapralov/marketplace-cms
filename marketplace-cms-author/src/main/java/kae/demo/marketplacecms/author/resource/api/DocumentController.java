package kae.demo.marketplacecms.author.resource.api;

import kae.demo.marketplacecms.author.application.DocumentService;
import kae.demo.marketplacecms.author.domain.model.Document;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/** */
@RestController
@RequestMapping("/api/document")
public class DocumentController {

  private final DocumentService service;

  public DocumentController(DocumentService service) {
    this.service = service;
  }

  @GetMapping
  public List<Document> getAll() {
    return service.getAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Document> get(@PathVariable("id") String id) {
    return service
        .findById(id)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }
}