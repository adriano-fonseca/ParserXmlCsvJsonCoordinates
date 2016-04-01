package org.company.gpx;

import java.math.BigDecimal;
import java.util.Calendar;

import org.apache.commons.lang.time.DateUtils;
import org.company.dao.FileDAO;
import org.company.dto.gpx.GpxDTO;
import org.company.util.UtilEnums;
import org.junit.Assert;
import org.junit.Test;

public class GpxTest {
  
  @Test
  public void shouldFailNotTwoTrk() {
    GpxDTO gpx = FileDAO.readFile("./xml/data.gpx", new GpxDTO(),UtilEnums.FileType.XML);
    Assert.assertEquals(2, gpx.getTrk().size());
  }
  
  @Test
  public void shouldFailIfNotOneTrkSeg() {
    GpxDTO gpx = FileDAO.readFile("./xml/data.gpx", new GpxDTO(), UtilEnums.FileType.XML);
    Assert.assertEquals(1, gpx.getTrk().get(0).getTrackSegmentList().size());
  }
  
  @Test
  public void shouldFailIfNotSevenTrkPoint() {
    GpxDTO gpx = FileDAO.readFile("./xml/data.gpx", new GpxDTO(),UtilEnums.FileType.XML);
    Assert.assertEquals(7, gpx.getTrk().get(0).getTrackSegmentList().get(0).getTrackPointList().size());
    System.out.println(gpx.getTrk().get(0).getTrackSegmentList().get(0).getTrackPointList().get(0).toString());
  }
  
  @Test
  public void shouldFailIfThereIsNotTwoTrkPoint() {
    GpxDTO gpx = FileDAO.readFile("./xml/data.gpx", new GpxDTO(),UtilEnums.FileType.XML);
    Assert.assertEquals(7, gpx.getTrk().get(0).getTrackSegmentList().get(0).getTrackPointList().size());
    System.out.println(gpx.getTrk().get(0).getTrackSegmentList().get(0).getTrackPointList().get(0).toString());
  }
  
  @Test
  public void searchPositionByDate(){
    GpxDTO gpx = FileDAO.readFile("./xml/data.gpx", new GpxDTO(), UtilEnums.FileType.XML);
    Calendar date1 = gpx.getTrk().get(0).getTrackSegmentList().get(0).getTrackPointList().get(0).getTime();
    Calendar date2 = gpx.getTrk().get(1).getTrackSegmentList().get(0).getTrackPointList().get(0).getTime();
//    DateFormat df=DateFormat.getDateTimeInstance();    
//    System.out.println("Before");
//    System.out.println(df.format(date1.getTime()));
//    System.out.println(df.format(date2.getTime()));
//    
//    Calendar date1Trunk = DateUtils.truncate(date1, Calendar.HOUR);
//    Calendar date2Trunk = DateUtils.truncate(date2, Calendar.HOUR);
//    
//    System.out.println("\nAfter");
//    System.out.println(df.format(date1Trunk.getTime()));
//    System.out.println(df.format(date2Trunk.getTime()));
//    
//    System.out.println(DateUtils.truncatedCompareTo(date1, date2, Calendar.MINUTE));
    Assert.assertEquals(true, DateUtils.truncatedEquals(date1, date2, Calendar.HOUR));
  }
  
  @Test
  public void shouldFailIfLatInConvertedFileIsNotTheSame(){
    GpxDTO gpx = FileDAO.readFile("./xml/data.gpx", new GpxDTO(), UtilEnums.FileType.XML);
    BigDecimal lat = gpx.getTrk().get(0).getTrackSegmentList().get(0).getTrackPointList().get(0).getLat();
//    System.out.println(lat);
    FileDAO.writeFile("./json/gpx.json", gpx, UtilEnums.FileType.JSON);
    GpxDTO gpxJ = FileDAO.readFile("./json/gpx.json", new GpxDTO(), UtilEnums.FileType.JSON);
    BigDecimal latJ = gpx.getTrk().get(0).getTrackSegmentList().get(0).getTrackPointList().get(0).getLat();
//    System.out.println("\n"+lat);
    //Return 0 if they are equal
    Assert.assertEquals(0, lat.compareTo(latJ));
  }

}
