package org.andird.model;

import java.io.Serializable;
import java.util.Locale;

import javax.xml.bind.annotation.XmlRootElement;

import org.joda.time.DateTime;

@XmlRootElement
public class MyTime implements Serializable {

  private static final long serialVersionUID = 5105187799831294875L;

  private String timeString;
  private String locale;

  public MyTime() {
    // do nothing
  }

  public MyTime(DateTime dateTime, Locale locale) {
    this.timeString = dateTime.toCalendar(locale).getTime().toString();
    this.locale = locale.getDisplayName();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (this.getClass() != obj.getClass()) {
      return false;
    }
    MyTime other = (MyTime) obj;
    if (this.locale == null) {
      if (other.locale != null) {
        return false;
      }
    } else if (!this.locale.equals(other.locale)) {
      return false;
    }
    if (this.timeString == null) {
      if (other.timeString != null) {
        return false;
      }
    } else if (!this.timeString.equals(other.timeString)) {
      return false;
    }
    return true;
  }

  public String getLocale() {
    return this.locale;
  }

  public String getTimeString() {
    return this.timeString;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + ((this.locale == null) ? 0 : this.locale.hashCode());
    result = (prime * result) + ((this.timeString == null) ? 0 : this.timeString.hashCode());
    return result;
  }

  public void setLocale(String locale) {
    this.locale = locale;
  }

  public void setTimeString(String timeStr) {
    this.timeString = timeStr;
  }

  @Override
  public String toString() {
    return String.format("MyTime [timeStr=%s, locale=%s, toString()=%s]", this.timeString,
        this.locale, super.toString());
  }

}
