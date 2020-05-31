package kae.demo.marketplacecms.author.domain.model;

import com.google.common.collect.ImmutableList;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import static kae.demo.marketplacecms.author.infrastructure.util.ImmutableCollections.toImmutableList;

/** */
public final class BannerCollection {

  @Id private final String id;

  private final String name;

  private final Content content;

  private final List<ContentVariation> contentVariations;

  @PersistenceConstructor
  private BannerCollection(
      String id, String name, Content content, Iterable<ContentVariation> contentVariations) {
    this.id = id;
    this.name = name;
    this.content = content;
    this.contentVariations = toImmutableList(contentVariations);
  }

  private BannerCollection(Builder builder) {
    this(builder.id, builder.name, builder.content, builder.contentVariations.build());
  }

  private BannerCollection withId(String id) {
    return new BannerCollection(id, name, content, contentVariations);
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
    return new StringJoiner(", ", BannerCollection.class.getSimpleName() + "[", "]")
        .add("id='" + id + "'")
        .add("name='" + name + "'")
        .add("content=" + content)
        .add("contentVariations=" + contentVariations)
        .toString();
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static final class Builder {

    private String id;
    private String name;
    private Content content;
    private final ImmutableList.Builder<ContentVariation> contentVariations =
        ImmutableList.builder();

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

    public Builder addContentVariation(ContentVariation val) {
      contentVariations.add(val);
      return this;
    }

    public Builder addAllContentVariations(Iterable<ContentVariation> val) {
      contentVariations.addAll(val);
      return this;
    }

    public BannerCollection build() {
      return new BannerCollection(this);
    }
  }

  public static final class Content {

    @DBRef private final List<Banner> banners;

    @PersistenceConstructor
    private Content(Iterable<Banner> banners) {
      this.banners = toImmutableList(banners);
    }

    private Content(Builder builder) {
      this(builder.banners.build());
    }

    public ImmutableList<Banner> getBanners() {
      return (ImmutableList<Banner>) banners;
    }

    @Override
    public String toString() {
      return new StringJoiner(", ", "[", "]")
          .add("banners=" + banners.stream().map(Banner::getId).collect(Collectors.joining()))
          .toString();
    }

    public static Builder newBuilder() {
      return new Builder();
    }

    public static final class Builder {
      private final ImmutableList.Builder<Banner> banners = ImmutableList.builder();

      private Builder() {}

      public Builder addBanner(Banner val) {
        banners.add(val);
        return this;
      }

      public Builder addAllBanners(List<Banner> val) {
        banners.addAll(val);
        return this;
      }

      public Content build() {
        return new Content(this);
      }
    }
  }

  public static final class ContentVariation {}
}
