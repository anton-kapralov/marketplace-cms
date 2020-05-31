package kae.demo.marketplacecms.author.infrastructure.util;

import com.google.common.collect.ImmutableList;

/** */
public final class ImmutableCollections {

  public static <T> ImmutableList<T> toImmutableList(Iterable<T> iterable) {
    return iterable != null
        ? iterable instanceof ImmutableList
            ? (ImmutableList<T>) iterable
            : ImmutableList.copyOf(iterable)
        : ImmutableList.of();
  }

  private ImmutableCollections() {}
}
