package org.company.json;

import java.math.BigDecimal;
import java.util.Calendar;

import org.company.dao.FileDAO;
import org.company.dao.JsonFileDAO;
import org.company.dto.DataFileDTO;
import org.company.dto.DataRecordDTO;
import org.company.util.UtilEnums;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JsonReadWriteTest {
  private String path;
  private DataFileDTO dataFileDTO;
  
  @Before
  public void setUp() throws Exception {
    path = "./json/dataC.json";
    dataFileDTO = new DataFileDTO();

    DataRecordDTO dataRecordDTO1 = new DataRecordDTO();
    dataRecordDTO1.setId(1L);
    dataRecordDTO1.setVehicle("Truck A");
    dataRecordDTO1.setLatitude(new BigDecimal(30.150));
    dataRecordDTO1.setLongitude(new BigDecimal(-55.150));
    dataRecordDTO1.setDateCalendar(Calendar.getInstance());

    DataRecordDTO dataRecordDTO = new DataRecordDTO();
    dataRecordDTO.setId(2L);
    dataRecordDTO.setVehicle("Truck B");
    dataRecordDTO.setLatitude(new BigDecimal(35.150));
    dataRecordDTO.setLongitude(new BigDecimal(-45.150));
    
    DataRecordDTO dataRecordDTO3 = new DataRecordDTO();
    dataRecordDTO3.setId(3L);
    dataRecordDTO3.setVehicle("Truck C");
    dataRecordDTO3.setLatitude(new BigDecimal(35.150));
    dataRecordDTO3.setLongitude(new BigDecimal(-45.150));
    
    Calendar dt =Calendar.getInstance();
    dt.set(1986, 6, 23);
    dataRecordDTO.setDateCalendar(dt);
    
    dataFileDTO.getData().add(dataRecordDTO);
    dataFileDTO.getData().add(dataRecordDTO1);
    dataFileDTO.getData().add(dataRecordDTO3);
  }
  
  @Test
  public void writeReadTest(){
    FileDAO.writeFile(path,dataFileDTO,UtilEnums.FileType.JSON);
    DataFileDTO data = FileDAO.readFile(path,new DataFileDTO(),UtilEnums.FileType.JSON);
    Assert.assertEquals(3, data.getData().size());
  }
}
