package kae.demo.marketplacecms.author.domain.model;

import java.util.StringJoiner;

/** */
public class Banner {

  private String title;

  private String subtitle;

  Banner() {}

  private Banner(Builder builder) {
    title = builder.title;
    subtitle = builder.subtitle;
  }

  public String getTitle() {
    return title;
  }

  public String getSubtitle() {
    return subtitle;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Banner.class.getSimpleName() + "[", "]")
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

    public Banner build() {
      return new Banner(this);
    }
  }
}
