package org.andird.service;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Service;

@Service(value = "TimeServiceImpl")
public class TimeServiceImpl implements TimeService {

    @Override
    public String getCurrentTime(Locale locale) {
	// Date format is not thread-safe
	DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
		DateFormat.LONG, locale);

	return dateFormat.format(new Date());
    }
}
