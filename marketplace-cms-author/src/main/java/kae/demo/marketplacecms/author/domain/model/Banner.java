package kae.demo.marketplacecms.author.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

import java.util.StringJoiner;

/** */
public class Banner {

  @Id private final String id;

  private final String name;

  private final Content content;

  @PersistenceConstructor
  private Banner(String id, String name, Content content) {
    this.id = id;
    this.name = name;
    this.content = content;
  }

  private Banner(Builder builder) {
    this(builder.id, builder.name, builder.content);
  }

  public Banner withId(String id) {
    return new Banner(id, name, content);
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Content getContent() {
    return content;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Banner.class.getSimpleName() + "[", "]")
        .add("id='" + id + "'")
        .add("name='" + name + "'")
        .add("content=" + content)
        .toString();
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static final class Builder {
    private String id;
    private String name;
    private Content content;

    private Builder() {}

    public Builder setId(String val) {
      id = val;
      return this;
    }

    public Builder setName(String val) {
      name = val;
      return this;
    }

    public Builder setContent(Content val) {
      content = val;
      return this;
    }

    public Banner build() {
      return new Banner(this);
    }
  }

  public static class Content {
    private final String title;

    private final String subtitle;

    @PersistenceConstructor
    private Content(String title, String subtitle) {
      this.title = title;
      this.subtitle = subtitle;
    }

    private Content(Builder builder) {
      this(builder.title, builder.subtitle);
    }

    public String getTitle() {
      return title;
    }

    public String getSubtitle() {
      return subtitle;
    }

    @Override
    public String toString() {
      return new StringJoiner(", ", "[", "]")
          .add("title='" + title + "'")
          .add("subtitle='" + subtitle + "'")
          .toString();
    }

    public static Builder newBuilder() {
      return new Builder();
    }

    public static final class Builder {
      private String title;
      private String subtitle;

      private Builder() {}

      public Builder setTitle(String val) {
        title = val;
        return this;
      }

      public Builder setSubtitle(String val) {
        subtitle = val;
        return this;
      }

      public Content build() {
        return new Content(this);
      }
    }
  }
}
