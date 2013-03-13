package org.andird.service;

import java.util.Locale;

public interface TimeService {

    /**
     * @return current time in LONG format according to specified Locale.
     */
    String getCurrentTime(Locale locale);
}
