package kae.demo.marketplacecms.author.resource.api;

import kae.demo.marketplacecms.author.application.DocumentService;
import kae.demo.marketplacecms.author.application.representation.Document;
import kae.demo.marketplacecms.author.domain.model.DocumentType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/** */
@RestController
@RequestMapping("/api/document")
public class DocumentController {

  private final DocumentService service;

  public DocumentController(DocumentService service) {
    this.service = service;
  }

  @GetMapping
  public Flux<Document> getAll() {
    return service.getAll();
  }

  @GetMapping("/{id}")
  public Mono<ResponseEntity<Document>> get(
      @PathVariable("id") String id, @RequestParam("type") DocumentType type) {
    return service
        .findByIdType(id, type)
        .map(ResponseEntity::ok)
        .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
  }
}
