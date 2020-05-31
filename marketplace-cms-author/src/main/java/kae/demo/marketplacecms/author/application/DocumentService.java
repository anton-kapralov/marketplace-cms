package kae.demo.marketplacecms.author.application;

import kae.demo.marketplacecms.author.application.representation.Document;
import kae.demo.marketplacecms.author.domain.model.DocumentType;
import kae.demo.marketplacecms.author.infrastructure.persistence.BannerRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/** */
@Service
public class DocumentService {

  private final BannerRepository bannerRepository;

  public DocumentService(BannerRepository bannerRepository) {
    this.bannerRepository = bannerRepository;
  }

  public Flux<Document> getAll() {
    return bannerRepository.findAll().map(Document::fromBanner);
  }

  public Mono<Document> findByIdType(String id, DocumentType type) {
    switch (type) {
      case BANNER:
        return bannerRepository.findById(id).map(Document::fromBanner);
      default:
        return Mono.empty();
    }
  }
}
