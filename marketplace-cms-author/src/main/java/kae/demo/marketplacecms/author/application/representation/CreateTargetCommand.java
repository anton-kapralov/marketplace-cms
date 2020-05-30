package kae.demo.marketplacecms.author.application.representation;

import kae.demo.marketplacecms.author.domain.model.Target;

/** */
public final class CreateTargetCommand {

  private final String name;

  private final String country;

  private final String language;

  public CreateTargetCommand(String name, String country, String language) {
    this.name = name;
    this.country = country;
    this.language = language;
  }

  public Target asTarget() {
    return Target.newBuilder().setName(name).setCountry(country).setLanguage(language).build();
  }
}
