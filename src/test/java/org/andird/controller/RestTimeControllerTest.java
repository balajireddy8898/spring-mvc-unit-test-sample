package org.andird.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.Locale;

import org.andird.model.MyTime;
import org.andird.service.TimeService;
import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

public class RestTimeControllerTest {

  private static final Logger LOG = LoggerFactory.getLogger(RestTimeControllerTest.class);

  private static final Locale LOCALE_SAMPLE = Locale.JAPAN;

  private static final MyTime DATE_TIME_SAMPLE = new MyTime(DateTime.now(),
      RestTimeControllerTest.LOCALE_SAMPLE);

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
  public void homeAssertMavTestJson() throws Exception {
    // note: we don't call the controller method manually here!
    MvcResult mvcResult =
        this.mockMvc
            .perform(
            get(UrlMapping.API_TIME).accept(MediaType.APPLICATION_JSON).locale(
                RestTimeControllerTest.LOCALE_SAMPLE))
            .andExpect(status().isOk())
            .andExpect(
                jsonPath("$.timeStr", equalTo(RestTimeControllerTest.DATE_TIME_SAMPLE.getTimeStr())))
                    .andExpect(
                        jsonPath("$.locale", equalTo(RestTimeControllerTest.DATE_TIME_SAMPLE.getLocale())))
                        .andReturn();

    verify(this.timeService).getCurrentTime(RestTimeControllerTest.LOCALE_SAMPLE);

    RestTimeControllerTest.LOG.info(mvcResult.getResponse().getContentAsString());
  }

  @Test
  public void homeAssertMavTestXml() throws Exception {
    // note: we don't call the controller method manually here!
    MvcResult mvcResult =
        this.mockMvc
        .perform(
            get(UrlMapping.API_TIME).accept(MediaType.APPLICATION_XML).locale(
                RestTimeControllerTest.LOCALE_SAMPLE)).andExpect(status().isOk()).andReturn();

    verify(this.timeService).getCurrentTime(RestTimeControllerTest.LOCALE_SAMPLE);

    RestTimeControllerTest.LOG.info(mvcResult.getResponse().getContentAsString());
  }

  private void mockCollaborators() {
    when(this.timeService.getCurrentTime(RestTimeControllerTest.LOCALE_SAMPLE)).thenReturn(
        RestTimeControllerTest.DATE_TIME_SAMPLE);
  }
}
