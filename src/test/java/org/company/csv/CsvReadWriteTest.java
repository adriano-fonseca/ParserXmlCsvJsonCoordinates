package org.company.csv;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.company.dao.CsvDAO;
import org.company.dto.DataRecordDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CsvReadWriteTest {

  private static List<DataRecordDTO> lista;

  final static String[]      FILE_HEADER_MAPPING = { "id", "vehicle", "latitude", "longitude", "date" };

  @Before
  public void setUp() throws Exception {
    lista = new ArrayList<DataRecordDTO>();

    //creating Data
    lista.add(new DataRecordDTO(1L, "Truck A", new BigDecimal(-30.55), new BigDecimal(-45.60), Calendar.getInstance()));
    lista.add(new DataRecordDTO(2L, "Truck B", new BigDecimal(30.55), new BigDecimal(45.60), Calendar.getInstance()));
    lista.add(new DataRecordDTO(3L, "Truck C", new BigDecimal(10.55), new BigDecimal(-15.60), Calendar.getInstance()));
  }

  @Test
  public void writeReadTest() {
    CsvDAO.writeToCSV(lista, "id,truck,lat,long,date", "./csv/new.csv");
    List<DataRecordDTO> lista = CsvDAO.readToCSV(new DataRecordDTO(), "./csv/new.csv");
    Assert.assertEquals(3, lista.size());
  }
}
