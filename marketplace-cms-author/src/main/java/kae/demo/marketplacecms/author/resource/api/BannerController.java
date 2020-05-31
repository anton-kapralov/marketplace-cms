package kae.demo.marketplacecms.author.resource.api;

import kae.demo.marketplacecms.author.application.BannerService;
import kae.demo.marketplacecms.author.application.representation.CreateBannerCommand;
import kae.demo.marketplacecms.author.application.representation.CreateBannerVariationCommand;
import kae.demo.marketplacecms.author.domain.model.Banner;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

/** */
@RestController
@RequestMapping("/api/banner")
public class BannerController {

  private final BannerService service;

  public BannerController(BannerService service) {
    this.service = service;
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public Mono<ResponseEntity<?>> create(
      @RequestBody @Valid CreateBannerCommand command, UriComponentsBuilder uriComponentsBuilder) {
    return service
        .create(command)
        .map(
            banner ->
                ResponseEntity.created(
                        uriComponentsBuilder
                            .path("/api/banner/{id}")
                            .buildAndExpand(banner.getId())
                            .toUri())
                    .build());
  }

  @GetMapping("/{id}")
  public Mono<ResponseEntity<Banner>> get(@PathVariable("id") String id) {
    return service
        .findById(id)
        .doOnNext(System.out::println)
        .map(ResponseEntity::ok)
        .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
  }

  @PostMapping(path = "/{id}/variation", consumes = MediaType.APPLICATION_JSON_VALUE)
  public Mono<ResponseEntity<?>> createContentVariation(
      @PathVariable("id") String id,
      @RequestBody @Valid CreateBannerVariationCommand command,
      UriComponentsBuilder uriComponentsBuilder) {
    return service
        .createContentVariation(id, command)
        .map(
            banner ->
                ResponseEntity.created(
                        uriComponentsBuilder
                            .path("/api/banner/{id}")
                            .buildAndExpand(banner.getId())
                            .toUri())
                    .build());
  }
}
