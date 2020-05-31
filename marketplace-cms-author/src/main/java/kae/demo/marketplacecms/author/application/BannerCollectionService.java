package kae.demo.marketplacecms.author.application;

import kae.demo.marketplacecms.author.application.representation.CreateBannerCollectionCommand;
import kae.demo.marketplacecms.author.domain.model.BannerCollection;
import kae.demo.marketplacecms.author.infrastructure.BannerCollectionRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

/** */
@Service
public class BannerCollectionService {

  private final BannerCollectionRepository repository;

  BannerCollectionService(BannerCollectionRepository repository) {
    this.repository = repository;
  }

  public Mono<BannerCollection> create(CreateBannerCollectionCommand command) {
    return repository.save(command.asBannerCollection());
  }

  public Flux<BannerCollection> findAll() {
    return repository.findAll();
  }

  public Mono<BannerCollection> findById(String id) {
    return repository.findById(id);
  }
}
