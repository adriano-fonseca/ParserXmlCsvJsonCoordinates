package org.company.coordinate;

import java.math.BigDecimal;

import junit.framework.Assert;

import org.company.coordinate.converter.CoordinateConverter;
import org.company.coordinate.dto.DDCoordinatePairDTO;
import org.company.coordinate.dto.DMSCoordinateDTO;
import org.company.coordinate.dto.DMSCoordinatePairDTO;
import org.junit.Before;
import org.junit.Test;

public class CoordinateUnitConverterTest {

  @Test
  public void testConvertDMSCoordinatePairtoDDPair() {
    //    Girassol, Petropolis - Porto Alegere -30.0450479 -51.12681359999999
    //    -30.0450479  --->  30° 2' 42,172" S
    //    -51.12681359999999 ---> 51° 7' 36,528" W
    DMSCoordinateDTO latide = new DMSCoordinateDTO(30, 2, new BigDecimal(42.172), 'S');
    DMSCoordinateDTO longitude = new DMSCoordinateDTO(51, 7, new BigDecimal(36.528), 'W');
    DMSCoordinatePairDTO dmsPairTested = new DMSCoordinatePairDTO(latide, longitude);
    DDCoordinatePairDTO ddPairExpected = new DDCoordinatePairDTO(new BigDecimal(-30.0450477777777),new BigDecimal(-51.1268133333334));
    DDCoordinatePairDTO ddPairReturned = CoordinateConverter.convertDMSCoordinatePairtoDDPair(dmsPairTested);
    Assert.assertEquals(ddPairExpected, ddPairReturned);
  }
  
  
  @Test
  public void testConvertDDCoordinatePairtoDMSPair() {
    //    Girassol, Petropolis - Porto Alegere -30.0450479 -51.12681359999999
    //    -30.0450479  --->  30° 2' 42,172" S
    //    -51.12681359999999 ---> 51° 7' 36,528" W
    DMSCoordinateDTO latitude = new DMSCoordinateDTO(30, 2, new BigDecimal(42.172), 'S');
    DMSCoordinateDTO longitude = new DMSCoordinateDTO(51, 7, new BigDecimal(36.528), 'W');
    DMSCoordinatePairDTO dmsPairExpected = new DMSCoordinatePairDTO(latitude, longitude);
    DDCoordinatePairDTO ddPairTested = new DDCoordinatePairDTO(new BigDecimal(-30.0450477777777),new BigDecimal(-51.1268133333333));
    DMSCoordinatePairDTO dmsPairReturned = CoordinateConverter.convertDDCoordinatePairToDMSPair(ddPairTested);
    dmsPairReturned.getLatitude().toString();
    dmsPairReturned.getLongitude().toString();
    Assert.assertEquals(dmsPairExpected, dmsPairReturned);
  }
  
  
//  @Test
//  public void testConvertDDtoDMS() {
//    //    Girassol, Petropolis - Porto Alegere -30.0450479 -51.12681359999999
//    //    -30.0450479  --->  30° 2' 42,172" S
//    //    -51.12681359999999 ---> 51° 7' 36,528" W
//    DMSCoordinateDTO dmsDTO = CoordinateConverter.convertDDtoDMS(-30.04504777777778D, "Lat");
//    DMSCoordinateDTO dmsDTOExpected = new DMSCoordinateDTO(30.0, 2.702866666666708, 42.17200000000247, 'S');
//    Assert.assertEquals(dmsDTO, dmsDTOExpected);
//  }
  

  //Facebook Silicon Valley
  //N 37º 29 5.451"
  //W 122º 8 54.189"

  //Louvre Museum, Paris
  //48.8606111  -> N 48 51' 38.2"
  //2.3376439999999548 -> E 2 20' 15.518"

}
