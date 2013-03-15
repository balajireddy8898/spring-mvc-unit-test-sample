package org.andird.service;

import java.util.Locale;

/**
 * 
 */
public interface TimeService {

    /**
     * @param locale
     * @return current time in LONG format according to specified Locale.
     */
    String getCurrentTime(final Locale locale);
}
