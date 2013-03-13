package org.andird.controller;

import java.util.Locale;

import javax.inject.Inject;
import javax.inject.Named;

import org.andird.service.TimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory
	    .getLogger(HomeController.class);

    @Inject
    @Named("TimeServiceImpl")
    private TimeService timeService;

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
	HomeController.logger.info("Welcome home! The client locale is {}.",
		locale);

	model.addAttribute("serverTime",
		this.timeService.getCurrentTime(locale));

	return "home";
    }

}
