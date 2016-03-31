package org.company.csv;

import java.math.BigDecimal;
import java.util.Calendar;

import org.company.dao.CsvFileDAO;
import org.company.dto.DataFileDTO;
import org.company.dto.DataRecordDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CSVReadWriteTest {
  private String path;
  private DataFileDTO dataFileDTO;
  final static String[] FILE_HEADER_MAPPING = { "id", "vehicle", "latitude", "longitude", "date" };
  
  @Before
  public void setUp() throws Exception {
    path = "./csv/dataFile.csv";
    dataFileDTO = new DataFileDTO();

    //creating Data
    dataFileDTO.getData().add(new DataRecordDTO(1L, "Truck A", new BigDecimal(-30.55), new BigDecimal(-45.60), Calendar.getInstance()));
    dataFileDTO.getData().add(new DataRecordDTO(2L, "Truck B", new BigDecimal(30.55), new BigDecimal(45.60), Calendar.getInstance()));
    dataFileDTO.getData().add(new DataRecordDTO(3L, "Truck C", new BigDecimal(10.55), new BigDecimal(-15.60), Calendar.getInstance()));
  }
  
  @Test
  public void writeReadTest(){
    CsvFileDAO.writeCsvFile(path, dataFileDTO);
    DataFileDTO data = CsvFileDAO.readCsvFile(path, FILE_HEADER_MAPPING);
    Assert.assertEquals(3, data.getData().size());
  }
}
