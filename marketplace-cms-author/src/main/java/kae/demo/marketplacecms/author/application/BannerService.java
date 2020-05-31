package kae.demo.marketplacecms.author.application;

import kae.demo.marketplacecms.author.application.representation.CreateBannerCommand;
import kae.demo.marketplacecms.author.application.representation.CreateBannerVariationCommand;
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

  public Mono<Banner> createContentVariation(String id, CreateBannerVariationCommand command) {
    return repository
        .findById(id)
        .flatMap(banner -> addContentVariation(banner, command.asBannerContentVariation()));
  }

  private Mono<Banner> addContentVariation(
      Banner banner, Banner.ContentVariation contentVariation) {
    Banner updated = Banner.newBuilder(banner).addContentVariation(contentVariation).build();
    return repository.save(updated);
  }
}
