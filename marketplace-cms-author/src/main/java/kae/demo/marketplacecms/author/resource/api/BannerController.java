package kae.demo.marketplacecms.author.resource.api;

import kae.demo.marketplacecms.author.application.DocumentService;
import kae.demo.marketplacecms.author.application.representation.CreateBannerCommand;
import kae.demo.marketplacecms.author.domain.model.Document;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

/** */
@RestController
@RequestMapping("/api/banner")
public class BannerController {

  private final DocumentService service;

  public BannerController(DocumentService service) {
    this.service = service;
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> create(
      @RequestBody @Valid CreateBannerCommand command, UriComponentsBuilder uriComponentsBuilder) {
    Document document = service.createBanner(command);
    return ResponseEntity.created(
            uriComponentsBuilder
                .path("/api/document/{id}")
                .buildAndExpand(document.getId())
                .toUri())
        .build();
  }
}
