package kae.demo.marketplacecms.author.application;

import kae.demo.marketplacecms.author.application.representation.CreateBannerCommand;
import kae.demo.marketplacecms.author.domain.model.Banner;
import kae.demo.marketplacecms.author.infrastructure.persistence.BannerRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/** */
@Service
public class BannerService {

  private final BannerRepository repository;

  BannerService(BannerRepository repository) {
    this.repository = repository;
  }

  public Mono<Banner> create(CreateBannerCommand command) {
    return repository.save(command.asBanner());
  }

  public Mono<Banner> findById(String id) {
    return repository.findById(id);
  }
}
