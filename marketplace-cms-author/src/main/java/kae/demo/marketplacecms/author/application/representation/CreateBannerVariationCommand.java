package kae.demo.marketplacecms.author.application.representation;

import kae.demo.marketplacecms.author.domain.model.Banner;

import java.util.List;

/** */
public final class CreateBannerVariationCommand {

  private final List<String> targetIds;

  private final String title;

  private final String subtitle;

  CreateBannerVariationCommand(List<String> targetIds, String title, String subtitle) {
    this.targetIds = targetIds;
    this.title = title;
    this.subtitle = subtitle;
  }

  public Banner.ContentVariation asBannerContentVariation() {
    return Banner.ContentVariation.newBuilder()
        .addAllTargetIds(targetIds)
        .setContent(Banner.Content.newBuilder().setTitle(title).setSubtitle(subtitle).build())
        .build();
  }
}
