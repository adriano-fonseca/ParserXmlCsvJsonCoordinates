package org.company.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.company.dto.DataFileDTO;
import org.company.util.UtilLog;
import org.xml.sax.InputSource;

public class XMLFileDAO {

  public static <T> T readXML(String path, T dto) {
    File file = new File(path);
    FileInputStream fis = null;
    JAXBContext jaxbContext = null;
    T dataFile = null;

    try {
      jaxbContext = JAXBContext.newInstance(dto.getClass());
      Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
      fis = new FileInputStream(file);
      InputSource is = new InputSource(fis);
      is.setEncoding("UTF-8");
      dataFile = (T) jaxbUnmarshaller.unmarshal(is);
    } catch (FileNotFoundException e) {
      UtilLog.logError("Cannot Read XML File! \n", e);
    } catch (JAXBException e) {
      UtilLog.logError("Cannot Bind XML To POJO! \n", e);
    }

    return dataFile;
  }

  public static <T> void writeXML(T dto, String path) {
    try {
      File file = new File(path);
      JAXBContext jaxbContext = JAXBContext.newInstance(dto.getClass());
      Marshaller jaxbMarshaller = jaxbContext.createMarshaller();


      jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      jaxbMarshaller.marshal(dto, file);
      
      // output pretty printed
      jaxbMarshaller.marshal(dto, System.out);
    } catch (JAXBException e) {
      e.printStackTrace();
    }
  }

}
