package kae.demo.marketplacecms.author.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

import java.util.Optional;
import java.util.StringJoiner;

/** */
public class Target {

  @Id private final String id;

  private final String name;

  private final String country;

  private final String language;

  @PersistenceConstructor
  private Target(String id, String name, String country, String language) {
    this.id = id;
    this.name = name;
    this.country = country;
    this.language = language;
  }

  private Target(Builder builder) {
    id = builder.id;
    name = builder.name;
    country = builder.country;
    language = builder.language;
  }

  public String getId() {
    return id;
  }

  public Optional<String> getName() {
    return Optional.ofNullable(name);
  }

  public Optional<String> getCountry() {
    return Optional.ofNullable(country);
  }

  public Optional<String> getLanguage() {
    return Optional.ofNullable(language);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Target.class.getSimpleName() + "[", "]")
        .add("id='" + id + "'")
        .add("name='" + name + "'")
        .add("country='" + country + "'")
        .add("language='" + language + "'")
        .toString();
  }

  public Target withId(String id) {
    return new Target(id, name, country, language);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static final class Builder {
    private String id;
    private String name;
    private String country;
    private String language;

    private Builder() {}

    public Builder setId(String val) {
      id = val;
      return this;
    }

    public Builder setName(String val) {
      name = val;
      return this;
    }

    public Builder setCountry(String val) {
      country = val;
      return this;
    }

    public Builder setLanguage(String val) {
      language = val;
      return this;
    }

    public Target build() {
      return new Target(this);
    }
  }
}
