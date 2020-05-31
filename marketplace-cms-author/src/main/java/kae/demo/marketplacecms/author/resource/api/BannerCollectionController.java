package kae.demo.marketplacecms.author.resource.api;

import kae.demo.marketplacecms.author.application.BannerCollectionService;
import kae.demo.marketplacecms.author.application.representation.CreateBannerCollectionCommand;
import kae.demo.marketplacecms.author.domain.model.BannerCollection;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

/** */
@RestController
@RequestMapping("/api/bannercollection")
public class BannerCollectionController {

  private final BannerCollectionService service;

  BannerCollectionController(BannerCollectionService service) {
    this.service = service;
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public Mono<ResponseEntity<?>> create(
      @RequestBody @Valid CreateBannerCollectionCommand command,
      UriComponentsBuilder uriComponentsBuilder) {
    return service
        .create(command)
        .map(
            bannerCollection ->
                ResponseEntity.created(
                        uriComponentsBuilder
                            .path("/api/bannercollection/{id}")
                            .buildAndExpand(bannerCollection.getId())
                            .toUri())
                    .build());
  }

  @GetMapping()
  public Flux<BannerCollection> getAll() {
    return service.findAll();
  }

  @GetMapping("/{id}")
  public Mono<ResponseEntity<BannerCollection>> get(@PathVariable("id") String id) {
    return service
        .findById(id)
        .map(ResponseEntity::ok)
        .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
  }
}
