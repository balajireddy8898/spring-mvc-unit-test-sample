package org.andird.service;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Named;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
@Named("TimeServiceImpl")
public class TimeServiceImpl implements TimeService {

    private static final Logger logger = LoggerFactory
	    .getLogger(TimeServiceImpl.class);

    @Override
    public String getCurrentTime(Locale locale) {
	TimeServiceImpl.logger.info("getting current time..");

	// Date format is not thread-safe
	DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
		DateFormat.LONG, locale);

	return dateFormat.format(new Date());
    }

}
