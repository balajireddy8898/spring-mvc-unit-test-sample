package org.andird.controller;

import java.util.Locale;

import javax.inject.Inject;
import javax.inject.Named;

import org.andird.model.MyTime;
import org.andird.service.TimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Handles requests for the application home page.
 */
@RestController
public class RestTimeController {

  /**
   *
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(RestTimeController.class);

  /**
   *
   */
  @Inject
  @Named("TimeServiceImpl")
  private TimeService timeService;

  /**
   * Simply selects the home view to render by returning its name.
   *
   * @param locale
   * @param model
   * @return
   */
  @RequestMapping(value = UrlMapping.API_TIME, method = RequestMethod.GET)
  public final MyTime time(final Locale locale) {
    RestTimeController.LOGGER.info("Welcome home! The client locale is {}.", locale);

    MyTime myTime = this.timeService.getCurrentTime(locale);
	return myTime;
  }

}
