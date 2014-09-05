package org.andird.service;

import javax.inject.Named;
import javax.inject.Singleton;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
@Named("TimeServiceImpl")
public class TimeServiceImpl implements TimeService {

  private static final Logger LOGGER = LoggerFactory.getLogger(TimeServiceImpl.class);

  @Override
  public final DateTime getCurrentTime() {
    TimeServiceImpl.LOGGER.info("getting current time..");
    return DateTime.now();
  }

}
