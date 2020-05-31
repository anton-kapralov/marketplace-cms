package kae.demo.marketplacecms.author.domain.model;

import com.google.common.collect.ImmutableList;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

import java.util.Collection;
import java.util.List;
import java.util.StringJoiner;

import static kae.demo.marketplacecms.author.infrastructure.util.ImmutableCollections.toImmutableList;

/** */
public class Banner {

  @Id private final String id;

  private final String name;

  private final Content content;

  private final List<ContentVariation> contentVariations;

  @PersistenceConstructor
  private Banner(
      String id, String name, Content content, Collection<ContentVariation> contentVariations) {
    this.id = id;
    this.name = name;
    this.content = content;
    this.contentVariations = toImmutableList(contentVariations);
  }

  private Banner(Builder builder) {
    this(builder.id, builder.name, builder.content, builder.contentVariations.build());
  }

  public Banner withId(String id) {
    return new Banner(id, name, content, contentVariations);
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

  public ImmutableList<ContentVariation> getContentVariations() {
    return (ImmutableList<ContentVariation>) contentVariations;
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

  public static Builder newBuilder(Banner another) {
    return new Builder(another);
  }

  public static final class Builder {
    private String id;
    private String name;
    private Content content;
    private final ImmutableList.Builder<ContentVariation> contentVariations =
        ImmutableList.builder();

    private Builder() {}

    public Builder(Banner another) {
      id = another.id;
      name = another.name;
      content = another.content;
      contentVariations.addAll(another.contentVariations);
    }

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

    public Builder addContentVariation(ContentVariation contentVariation) {
      contentVariations.add(contentVariation);
      return this;
    }

    public Builder addAllContentVariations(Iterable<ContentVariation> contentVariations) {
      this.contentVariations.addAll(contentVariations);
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

  public static class ContentVariation {
    private final List<String> targetIds;
    private final Content content;

    @PersistenceConstructor
    private ContentVariation(Collection<String> targetIds, Content content) {
      this.targetIds = toImmutableList(targetIds);
      this.content = content;
    }

    private ContentVariation(Builder builder) {
      this(builder.targetIds.build(), builder.content);
    }

    public ImmutableList<String> getTargetIds() {
      return (ImmutableList<String>) targetIds;
    }

    public Content getContent() {
      return content;
    }

    @Override
    public String toString() {
      return new StringJoiner(", ", ContentVariation.class.getSimpleName() + "[", "]")
          .add("target=" + targetIds)
          .add("content=" + content)
          .toString();
    }

    public static Builder newBuilder() {
      return new Builder();
    }

    public static final class Builder {
      private final ImmutableList.Builder<String> targetIds = ImmutableList.builder();
      private Content content;

      private Builder() {}

      public Builder addTargetId(String targetId) {
        targetIds.add(targetId);
        return this;
      }

      public Builder addAllTargetIds(Iterable<String> targetIds) {
        this.targetIds.addAll(targetIds);
        return this;
      }

      public Builder setContent(Content val) {
        content = val;
        return this;
      }

      public ContentVariation build() {
        return new ContentVariation(this);
      }
    }
  }
}
