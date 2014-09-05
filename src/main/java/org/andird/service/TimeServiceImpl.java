package org.andird.service;

import java.util.Locale;

import javax.inject.Named;
import javax.inject.Singleton;

import org.andird.model.MyTime;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
@Named("TimeServiceImpl")
public class TimeServiceImpl implements TimeService {

  private static final Logger LOGGER = LoggerFactory.getLogger(TimeServiceImpl.class);

  @Override
  public final MyTime getCurrentTime(Locale locale) {
    TimeServiceImpl.LOGGER.info("getting current time..with locale: {}", locale);

    return new MyTime(DateTime.now(), locale);
  }

}
