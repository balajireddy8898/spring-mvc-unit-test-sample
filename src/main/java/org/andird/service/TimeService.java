package org.andird.service;

import java.util.Locale;

import org.andird.model.MyTime;

/**
 *
 */
public interface TimeService {

  /**
   * @param locale
   * @return current time with specified Locale.
   */
  MyTime getCurrentTime(Locale locale);
}
