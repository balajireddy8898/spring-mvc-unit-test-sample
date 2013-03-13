package org.andird.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.Locale;

import org.andird.service.TimeService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

public class HomeControllerTest {

    private static final String PATH = "/";

    private static final String HOME = "home";

    private static final Locale ENGLISH = Locale.ENGLISH;

    private static final String EN_RESULT = "en-result";

    @InjectMocks
    private HomeController homeController;

    @Mock
    private TimeService timeService;

    private MockMvc mockMvc;

    private void mockCollaborators() {
	when(this.timeService.getCurrentTime(HomeControllerTest.ENGLISH))
		.thenReturn(HomeControllerTest.EN_RESULT);
    }

    @Before
    public void before() {
	initMocks(this);
	this.mockCollaborators();
	this.mockMvc = standaloneSetup(this.homeController).build();
    }

    @After
    public void after() {
	verifyNoMoreInteractions(this.timeService);
    }

    @Test
    public void homeTest() throws Exception {
	this.mockMvc.perform(get(HomeControllerTest.PATH)).andExpect(
		status().isOk());

	verify(this.timeService).getCurrentTime(HomeControllerTest.ENGLISH);
    }

    @Test
    public void homeAssertMavTest() throws Exception {
	MvcResult mvcResult = this.mockMvc
		.perform(get(HomeControllerTest.PATH)).andReturn();

	verify(this.timeService).getCurrentTime(HomeControllerTest.ENGLISH);

	ModelAndView modelAndView = mvcResult.getModelAndView();

	// assertions
	assertThat(modelAndView, notNullValue());
	assertThat(modelAndView.getViewName(), equalTo(HomeControllerTest.HOME));
	assertThat(modelAndView.getModel().size(), equalTo(1));
    }
}
