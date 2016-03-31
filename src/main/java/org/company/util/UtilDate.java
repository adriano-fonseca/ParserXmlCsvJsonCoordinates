package org.company.util;

import java.util.Calendar;

public class UtilDate {
  public static Calendar stringToCalendar(String date){
    Calendar dateCalendar = Calendar.getInstance();
    String[] dateParts = date.split("/");
    dateCalendar.set(Integer.parseInt(dateParts[2]), Integer.parseInt(dateParts[1])-1, Integer.parseInt(dateParts[0]));
    return dateCalendar;
  }
}
