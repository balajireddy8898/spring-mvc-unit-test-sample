package org.andird.model;

import java.io.Serializable;
import java.util.Locale;

import javax.xml.bind.annotation.XmlRootElement;

import org.joda.time.DateTime;

@XmlRootElement
public class MyTime implements Serializable {

  private static final long serialVersionUID = 5105187799831294875L;

  private String timeStr;
  private String locale;

  public MyTime() {
    // do nothing
  }

  public MyTime(DateTime dateTime, Locale locale) {
    this.timeStr = dateTime.toCalendar(locale).getTime().toString();
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
    if (this.timeStr == null) {
      if (other.timeStr != null) {
        return false;
      }
    } else if (!this.timeStr.equals(other.timeStr)) {
      return false;
    }
    return true;
  }

  public String getLocale() {
    return this.locale;
  }

  public String getTimeStr() {
    return this.timeStr;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + ((this.locale == null) ? 0 : this.locale.hashCode());
    result = (prime * result) + ((this.timeStr == null) ? 0 : this.timeStr.hashCode());
    return result;
  }

  public void setLocale(String locale) {
    this.locale = locale;
  }

  public void setTimeStr(String timeStr) {
    this.timeStr = timeStr;
  }

  @Override
  public String toString() {
    return String.format("MyTime [timeStr=%s, locale=%s, toString()=%s]", this.timeStr,
        this.locale, super.toString());
  }

}
