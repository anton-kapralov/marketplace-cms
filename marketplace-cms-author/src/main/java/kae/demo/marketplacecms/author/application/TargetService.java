package kae.demo.marketplacecms.author.application;

import kae.demo.marketplacecms.author.application.representation.CreateTargetCommand;
import kae.demo.marketplacecms.author.domain.model.Target;
import kae.demo.marketplacecms.author.infrastructure.persistence.TargetRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/** */
@Service
public class TargetService {

  private final TargetRepository repository;

  TargetService(TargetRepository repository) {
    this.repository = repository;
  }

  public Flux<Target> getAll() {
    return repository.findAll();
  }

  public Mono<Target> create(CreateTargetCommand command) {
    return repository.save(command.asTarget());
  }

  public Mono<Target> findById(String id) {
    return repository.findById(id);
  }
}
