package org.andird.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Locale;

import org.andird.model.MyTime;
import org.andird.service.TimeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

public class TimeServiceImplTest {

  private static final Locale FRANCE = Locale.FRANCE;

  @InjectMocks
  private TimeServiceImpl serviceImpl;

  @Before
  public void before() {
    initMocks(this);
  }

  @Test
  public void getCurrentTimeTest() {
    MyTime myTime = this.serviceImpl.getCurrentTime(TimeServiceImplTest.FRANCE);

    assertThat(myTime, notNullValue());

    assertThat(myTime.getLocale(), equalTo(TimeServiceImplTest.FRANCE.getDisplayName()));

    assertThat(myTime.getTimeStr(), notNullValue());
  }
}
