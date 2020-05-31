package kae.demo.marketplacecms.author.application.representation;

import kae.demo.marketplacecms.author.domain.model.Banner;

/** */
public class CreateBannerCommand {

  private final String name;

  private final String title;

  private final String subtitle;

  public CreateBannerCommand(String name, String title, String subtitle) {
    this.name = name;
    this.title = title;
    this.subtitle = subtitle;
  }

  public Banner asBanner() {
    return Banner.newBuilder()
        .setName(name)
        .setContent(Banner.Content.newBuilder().setTitle(title).setSubtitle(subtitle).build())
        .build();
  }
}
