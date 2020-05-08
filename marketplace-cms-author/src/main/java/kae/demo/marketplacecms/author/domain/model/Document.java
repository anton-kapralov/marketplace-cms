package kae.demo.marketplacecms.author.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

import java.util.Optional;
import java.util.StringJoiner;

/** */
public class Document {

  @Id private final String id;

  private final DocumentType type;

  private final String name;

  private final Banner banner;

  @PersistenceConstructor
  private Document(String id, DocumentType type, String name, Banner banner) {
    this.id = id;
    this.type = type;
    this.name = name;
    this.banner = banner;
  }

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

  public Document withId(String id) {
    return new Document(id, type, name, banner);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static final class Builder {
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

    public Document build() {
      return new Document(this);
    }
  }
}
