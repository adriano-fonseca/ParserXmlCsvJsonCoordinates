package org.company.util;

import java.text.DateFormat;
import java.util.Calendar;

import org.company.util.UtilDate;
import org.junit.Assert;
import org.junit.Test;




public class UtilDateTest {

  @Test
  public void shouldFailIfCalendarHasNotProperDate(){
    String date = "23/07/1986";
    Calendar dateCalendar = UtilDate.stringToCalendar(date);
    Calendar dateCalendarExpected = Calendar.getInstance();
    dateCalendarExpected.set(1986, 6, 23);
    DateFormat df=DateFormat.getDateInstance(DateFormat.MEDIUM);
    Assert.assertEquals(df.format(dateCalendarExpected.getTime()),df.format(dateCalendar.getTime()));
    System.out.println(df.format(dateCalendar.getTime()));
  }
}
