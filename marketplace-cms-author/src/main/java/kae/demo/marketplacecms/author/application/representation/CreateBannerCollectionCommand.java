package kae.demo.marketplacecms.author.application.representation;

import kae.demo.marketplacecms.author.domain.model.Banner;
import kae.demo.marketplacecms.author.domain.model.BannerCollection;

import java.util.List;

import static com.google.common.collect.ImmutableList.toImmutableList;

/** */
public final class CreateBannerCollectionCommand {

  private final String name;

  private final List<String> bannerIds;

  CreateBannerCollectionCommand(String name, List<String> bannerIds) {
    this.name = name;
    this.bannerIds = bannerIds;
  }

  public BannerCollection asBannerCollection() {
    return BannerCollection.newBuilder()
        .setName(name)
        .setContent(
            BannerCollection.Content.newBuilder()
                .addAllBanners(
                    bannerIds.stream()
                        .map(bannerId -> Banner.newBuilder().setId(bannerId).build())
                        .collect(toImmutableList()))
                .build())
        .build();
  }
}
