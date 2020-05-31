package kae.demo.marketplacecms.author.application.representation;

import kae.demo.marketplacecms.author.domain.model.Banner;
import kae.demo.marketplacecms.author.domain.model.DocumentType;

import java.util.Optional;
import java.util.StringJoiner;

/** */
public class Document {

  private final String id;

  private final DocumentType type;

  private final String name;

  private final Banner banner;

  private Document(Builder builder) {
    id = builder.id;
    type = builder.type;
    name = builder.name;
    banner = builder.banner;
  }

  public String getId() {
    return id;
  }

  public DocumentType getType() {
    return type;
  }

  public String getName() {
    return name;
  }

  public Optional<Banner> getBanner() {
    return Optional.ofNullable(banner);
  }

  @Override
  public String toString() {
    StringJoiner joiner =
        new StringJoiner(", ", Document.class.getSimpleName() + "[", "]")
            .add("id='" + id + "'")
            .add("type=" + type);

    if (banner != null) {
      joiner.add("banner=" + banner);
    }

    return joiner.toString();
  }

  public static Document fromBanner(Banner banner) {
    return Document.newBuilder()
        .setId(banner.getId())
        .setType(DocumentType.BANNER)
        .setName(banner.getName())
        .setBanner(banner)
        .build();
  }

  private static Builder newBuilder() {
    return new Builder();
  }

  private static final class Builder {
    private String id;
    private DocumentType type;
    private String name;
    private Banner banner;

    private Builder() {}

    public Builder setId(String val) {
      id = val;
      return this;
    }

    public Builder setType(DocumentType val) {
      type = val;
      return this;
    }

    public Builder setName(String val) {
      name = val;
      return this;
    }

    public Builder setBanner(Banner val) {
      banner = val;
      return this;
    }

    private Document build() {
      return new Document(this);
    }
  }
}
