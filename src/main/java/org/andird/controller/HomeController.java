package org.andird.controller;

import org.andird.service.TimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Locale;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

    /**
     *
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(HomeController.class);

    /**
     *
     */
    @Inject
    @Named("TimeServiceGroovy")
    private TimeService timeService;

    /**
     * Simply selects the home view to render by returning its name.
     *
     * @param locale
     * @param model
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public final String home(final Locale locale, final Model model) {
        HomeController.LOGGER.info("Welcome home! The client locale is {}.",
                locale);

        model.addAttribute("serverTime",
                this.timeService.getCurrentTime(locale));

        return "home";
    }

}
