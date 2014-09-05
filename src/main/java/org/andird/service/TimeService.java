package org.andird.service;

import org.joda.time.DateTime;

/**
 *
 */
public interface TimeService {

  /**
   * @param locale
   * @return current time with specified Locale.
   */
  DateTime getCurrentTime();
}
