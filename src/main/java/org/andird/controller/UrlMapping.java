package org.andird.controller;

public final class UrlMapping {

  private static final String API = "/api";

  private static final String TIME = "/time";

  public static final String API_TIME = UrlMapping.API + UrlMapping.TIME;

  private UrlMapping() {
    throw new UnsupportedOperationException("must not be instantiated");
  }
}
