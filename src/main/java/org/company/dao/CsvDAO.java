package org.company.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.company.converter.CalendarConverter;
import org.company.converter.DoubleConverter;
import org.company.converter.LongConverter;
import org.company.converter.ShortConverter;
import org.company.util.UtilLog;
import org.jsefa.common.lowlevel.filter.HeaderAndFooterFilter;
import org.jsefa.csv.CsvDeserializer;
import org.jsefa.csv.CsvIOFactory;
import org.jsefa.csv.CsvSerializer;
import org.jsefa.csv.config.CsvConfiguration;

public class CsvDAO {

  public static <T> void writeToCSV(List<T> data, String header, String path) {
    CsvConfiguration config = getConfig();

    CsvSerializer serializer = (CsvSerializer) CsvIOFactory.createFactory(config, data.get(0).getClass()).createSerializer();
    FileWriter writer=null;
    
    try {
      writer = new FileWriter(path);
    } catch (IOException e) {
      UtilLog.logError("Cannot Create CSV File!", e);
    }
    serializer.open(writer);
    serializer.getLowLevelSerializer().writeLine(header); // the header
    serializer.open(writer);
    for (T record : data) {
      serializer.write(record);
    }

    serializer.close(true);
    System.out.println(writer.toString());
  }

  public static <T> List<T> readToCSV(T record, String path) {
    FileReader fileReader = getFileReader(path);
    CsvConfiguration config = getConfig(); 
    
    CsvDeserializer deserializer = CsvIOFactory.createFactory(config, record.getClass()).createDeserializer();
    deserializer.open(fileReader);
    List<T> dataFile = new ArrayList<T>();

    while (deserializer.hasNext()) {
      record = deserializer.next();
      dataFile.add(record);
    }
    String header = deserializer.getStoredLines().get(0).getContent();
    deserializer.close(true);
    return dataFile;
  }

  private static FileReader getFileReader(String path) {
    FileReader fileReader =null;
    try {
      fileReader = new FileReader(path);
    } catch (FileNotFoundException e) {
      UtilLog.logError("Cannot Read CSV File!", e);
    }
    return fileReader;
  }

  private static CsvConfiguration getConfig() {
    CsvConfiguration config = new CsvConfiguration();
    config.setFieldDelimiter(',');
    config.getSimpleTypeConverterProvider().registerConverterType(Long.class, LongConverter.class);
    config.getSimpleTypeConverterProvider().registerConverterType(Double.class, DoubleConverter.class);
    config.getSimpleTypeConverterProvider().registerConverterType(Short.class, ShortConverter.class);
    config.getSimpleTypeConverterProvider().registerConverterType(Calendar.class, CalendarConverter.class);

    // header of size 1, no footer, store the filtered lines
    config.setLineFilter(new HeaderAndFooterFilter(1, false, true));
    return config;
  }

}