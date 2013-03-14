package org.andird.service

import groovy.transform.TypeChecked

import java.text.DateFormat

import javax.inject.Named
import javax.inject.Singleton

import org.slf4j.Logger
import org.slf4j.LoggerFactory

@TypeChecked
@Singleton
@Named("TimeServiceGroovy")
class TimeServiceGroovy implements TimeService {

    private static final Logger logger = LoggerFactory.getLogger(TimeServiceGroovy.class)

    @Override
    public String getCurrentTime(Locale locale) {
	TimeServiceGroovy.logger.info("getting current time..")

	// Date format is not thread-safe
	DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
		DateFormat.LONG, locale)

	dateFormat.format(new Date())
    }
}
