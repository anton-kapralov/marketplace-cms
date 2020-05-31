package kae.demo.marketplacecms.author.infrastructure;

import kae.demo.marketplacecms.author.domain.model.BannerCollection;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/** */
@Repository
public interface BannerCollectionRepository
    extends ReactiveMongoRepository<BannerCollection, String> {}
