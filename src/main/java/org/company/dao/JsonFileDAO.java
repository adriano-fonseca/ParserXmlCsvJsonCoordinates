package org.company.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.company.util.UtilLog;
import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.xml.sax.InputSource;

public class JsonFileDAO {

   public static <T> T readJason(T dto, String path) {
    File file = new File(path);
    FileInputStream fis = null;
    JAXBContext jaxbContext = null;
    T dataFile = null;

    try {
      jaxbContext = JAXBContext.newInstance(dto.getClass());
      Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
      unmarshaller.setProperty("eclipselink.media-type", "application/json");
      fis = new FileInputStream(file);
      InputSource is = new InputSource(fis);
      is.setEncoding("UTF-8");
      dataFile = (T) unmarshaller.unmarshal(is);
    }  catch (FileNotFoundException e) {
      UtilLog.logError("Cannot Read XML File! \n", e);
    }catch (JAXBException e) {
      UtilLog.logError("Cannot Bind XML To POJO! \n", e);
    }

    return dataFile;
  }

  public static <T> void writeJson(T dto, String path) {
    try {
      File file = new File(path);
      JAXBContext jc = JAXBContext.newInstance(dto.getClass());

      // Create the Marshaller Object using the JaxB Context
      Marshaller marshaller = jc.createMarshaller();

      // Set the Marshaller media type to JSON or XML
      marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");

      // Set it to true if you need to include the JSON root element in the JSON output
      marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);

      // Set it to true if you need the JSON output to formatted
      marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      marshaller.marshal(dto, file);

      // output pretty printed
      marshaller.marshal(dto, System.out);
    } catch (JAXBException e) {
      UtilLog.logError("Cannot Bind XML To POJO! \n", e);
    }

    // Marshal the employee object to JSON and print the output to console
  }

  public static <T> void writeXML(T dto, String path) {
    try {
      File file = new File(path);
      JAXBContext jaxbContext = JAXBContext.newInstance(dto.getClass());
      Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

      // output pretty printed
      jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

      jaxbMarshaller.marshal(dto, file);
      jaxbMarshaller.marshal(dto, System.out);
    } catch (JAXBException e) {
      e.printStackTrace();
    }
  }

}
