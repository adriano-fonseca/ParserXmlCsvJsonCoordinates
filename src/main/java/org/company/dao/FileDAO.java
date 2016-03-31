package org.company.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.company.util.UtilLog;
import org.company.util.UtilEnums.FileType;
import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.xml.sax.InputSource;

public class FileDAO {
  public static <T> T readFile(String path, T dto, FileType fileType) {
    File file = new File(path);
    FileInputStream fis = null;
    JAXBContext jaxbContext = null;
    T dataFile = null;

    try {
      jaxbContext = JAXBContext.newInstance(dto.getClass());
      Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
      
      if(fileType.getId().equals(fileType.JSON.getId())){
        unmarshaller.setProperty("eclipselink.media-type", "application/json");
      }
      
      fis = new FileInputStream(file);
      InputSource is = new InputSource(fis);
      is.setEncoding("UTF-8");
      dataFile = (T) unmarshaller.unmarshal(is);
    } catch (FileNotFoundException e) {
      UtilLog.logError("Cannot Read File! \n", e);
    } catch (JAXBException e) {
      e.printStackTrace();
    }

    return dataFile;
  }
  
  public static <T> void writeFile(String path, T dto, FileType fileType) {
    try {
      File file = new File(path);
      JAXBContext jaxbContext = JAXBContext.newInstance(dto.getClass());
      Marshaller marshaller = jaxbContext.createMarshaller();
      
      if(fileType.getId().equals(fileType.JSON.getId())){
        marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
        marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);
      }
      
      // Set it to true if you need the JSON output to formatted
      marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      marshaller.marshal(dto, file);
      
      // output pretty printed
      marshaller.marshal(dto, System.out);
    } catch (JAXBException e) {
      e.printStackTrace();
    }
  }

}
