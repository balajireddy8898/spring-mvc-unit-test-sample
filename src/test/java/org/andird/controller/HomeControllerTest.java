package org.andird.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.andird.service.TimeService;
import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

public class HomeControllerTest {

  private static final DateTime DATE_TIME_SAMPLE = DateTime.now();

  @InjectMocks
  private RestTimeController homeController;

  @Mock
  private TimeService timeService;

  private MockMvc mockMvc;

  @After
  public void after() {
    verifyNoMoreInteractions(this.timeService);
  }

  @Before
  public void before() {
    initMocks(this);
    this.mockCollaborators();
    this.mockMvc = standaloneSetup(this.homeController).build();
  }

  @Test
  public void homeAssertMavTest() throws Exception {
    // note: we don't call the controller method manually here!
    MvcResult mvcResult = this.mockMvc.perform(get(UrlMapping.API_TIME)).andReturn();

    verify(this.timeService).getCurrentTime();

    ModelAndView modelAndView = mvcResult.getModelAndView();
    System.out.println(mvcResult.getResponse().getContentAsString());
  }

  @Test
  public void homeTest() throws Exception {
    // note: we don't call the controller method manually here!
    this.mockMvc.perform(get(UrlMapping.API_TIME)).andExpect(status().isOk());

    verify(this.timeService).getCurrentTime();
  }

  private void mockCollaborators() {
    when(this.timeService.getCurrentTime()).thenReturn(HomeControllerTest.DATE_TIME_SAMPLE);
  }
}
