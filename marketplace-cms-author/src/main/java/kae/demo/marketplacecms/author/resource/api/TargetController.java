package kae.demo.marketplacecms.author.resource.api;

import kae.demo.marketplacecms.author.application.TargetService;
import kae.demo.marketplacecms.author.application.representation.CreateTargetCommand;
import kae.demo.marketplacecms.author.domain.model.Target;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

/** */
@RestController
@RequestMapping("/api/target")
public class TargetController {

  private final TargetService service;

  TargetController(TargetService service) {
    this.service = service;
  }

  @GetMapping
  public Flux<Target> getAll() {
    return service.getAll();
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public Mono<ResponseEntity<?>> create(
      @RequestBody @Valid CreateTargetCommand command, UriComponentsBuilder uriComponentsBuilder) {
    return service
        .create(command)
        .map(
            target ->
                ResponseEntity.created(
                        uriComponentsBuilder
                            .path("/api/target/{id}")
                            .buildAndExpand(target.getId())
                            .toUri())
                    .build());
  }

  @GetMapping("/{id}")
  public Mono<ResponseEntity<Target>> get(@PathVariable("id") String id) {
    return service
        .findById(id)
        .map(ResponseEntity::ok)
        .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
  }
}
