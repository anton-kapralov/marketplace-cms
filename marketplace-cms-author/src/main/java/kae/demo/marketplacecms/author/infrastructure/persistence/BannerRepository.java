package kae.demo.marketplacecms.author.infrastructure.persistence;

import kae.demo.marketplacecms.author.domain.model.Banner;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/** */
@Repository
public interface BannerRepository extends ReactiveMongoRepository<Banner, String> {}
