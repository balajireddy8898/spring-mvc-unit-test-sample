package org.andird.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Named;
import javax.inject.Singleton;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Singleton
@Named("TimeServiceImpl")
public class TimeServiceImpl implements TimeService {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(TimeServiceImpl.class);

    @Override
    public final String getCurrentTime(final Locale locale) {
        TimeServiceImpl.LOGGER.info("getting current time..");

        // Date format is not thread-safe
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
                DateFormat.LONG, locale);

        return dateFormat.format(new Date());
    }

}
