package kae.demo.marketplacecms.author.application.representation;

import kae.demo.marketplacecms.author.domain.model.Banner;
import kae.demo.marketplacecms.author.domain.model.Document;
import kae.demo.marketplacecms.author.domain.model.DocumentType;

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

  public Document asDocument() {
    return Document.newBuilder()
        .setType(DocumentType.BANNER)
        .setName(name)
        .setBanner(Banner.newBuilder().setTitle(title).setSubtitle(subtitle).build())
        .build();
  }
}
