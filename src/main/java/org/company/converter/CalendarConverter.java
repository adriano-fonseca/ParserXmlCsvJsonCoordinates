package org.company.converter;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.Calendar;

import org.jsefa.common.converter.SimpleTypeConverter;

public class CalendarConverter implements SimpleTypeConverter {

  private static final CalendarConverter INSTANCE = new CalendarConverter();

  public static CalendarConverter create() {
    return INSTANCE;
  }

  private CalendarConverter() {
  }

  @Override
  public Object fromString(String s) {
    if (s != null) {
      String[] stringParts = s.split("/");
      Calendar cal = Calendar.getInstance();
      cal.set(new Integer(stringParts[2]), new Integer(stringParts[1]), new Integer(stringParts[0]));
      return cal;
    } else {
      return null;
    }
  }

  @Override
  public String toString(Object d) {
    if (d != null) {
      DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
      Calendar cal = (Calendar) d;
      String date = df.format(cal.getTime());
      return date;
    } else {
      return null;
    }
  }

}