package org.company.dao;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.company.dto.DataFileDTO;
import org.company.dto.DataRecordDTO;
import org.company.util.UtilDate;
import org.company.util.UtilLog;

public class CsvFileDAO {

  //Delimiter
  private static final String   NEW_LINE_SEPARATOR = "\n";

  //CSV file header to write
  private static final Object[] FILE_HEADER        = { "id", "vehicle", "latitude", "longitude", "date" };

  //Record attributes
  private static final String   ID                 = "id";

  private static final String   VEHICLE            = "vehicle";

  private static final String   DATE               = "date";

  private static final String   LAT                = "latitude";

  private static final String   LON                = "longitude";

  public static DataFileDTO readCsvFile(String fileName, String[] FILE_HEADER_MAPPING) {
    FileReader fileReader = null;
    CSVParser csvFileParser = null;
    CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(FILE_HEADER_MAPPING);
    List<DataRecordDTO> records = new ArrayList<DataRecordDTO>();

    try {
      //initialize FileReader object
      fileReader = new FileReader(fileName);

      //initialize CSVParser object
      csvFileParser = new CSVParser(fileReader, csvFileFormat);

      //Get a list of CSV file records
      List<CSVRecord> csvRecords = csvFileParser.getRecords();

      //Read the CSV file records starting from the second record to skip the header
      for (int i = 1; i < csvRecords.size(); i++) {
        CSVRecord record = csvRecords.get(i);
        Calendar date = UtilDate.stringToCalendar(record.get(DATE));
        BigDecimal latitude = new BigDecimal(record.get(LAT));
        BigDecimal longitude = new BigDecimal(record.get(LON));
        DataRecordDTO recordDTO = new DataRecordDTO(Long.parseLong(record.get(ID)), record.get(VEHICLE), latitude, longitude, date);
        records.add(recordDTO);
      }
    } catch (Exception e) {
      UtilLog.logError("Cannot Read CSV File!", e);
    } finally {
      if (fileReader != null) {
        try {
          fileReader.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

      if (csvFileParser != null) {
        try {
          csvFileParser.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    
    return new DataFileDTO(records);
  }

  public static void writeCsvFile(String fileName, DataFileDTO dataFileDTO) {
    List<DataRecordDTO> records = dataFileDTO.getData();
    FileWriter fileWriter = null;
    CSVPrinter csvFilePrinter = null;

    //Create the CSVFormat object with "\n" as a record delimiter
    CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);
    try {
      //initialize FileWriter object
      fileWriter = new FileWriter(fileName);

      //initialize CSVPrinter object 
      csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);

      //Create CSV file header
      csvFilePrinter.printRecord(FILE_HEADER);

      //Write a new student object list to the CSV file
      for (DataRecordDTO record : records) {
        List<String> dataRecord = getDataRecordToCSV(record);
        csvFilePrinter.printRecord(dataRecord);
      }
      fileWriter.flush();
      fileWriter.close();
      csvFilePrinter.close();
    } catch (IOException e) {
      UtilLog.logError("Cannot Read CSV File!", e);
    }
  }

  private static List<String> getDataRecordToCSV(DataRecordDTO record) {
    List<String> dataRecord = new ArrayList<String>();
    dataRecord.add(String.valueOf(record.getId()));
    dataRecord.add(record.getVehicle());
    dataRecord.add(record.getLatitude().toString());
    dataRecord.add(record.getLongitude().toString());
    DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
    String dateString = df.format(record.getDate().getTime());
    dataRecord.add(dateString);
    return dataRecord;
  }
}
