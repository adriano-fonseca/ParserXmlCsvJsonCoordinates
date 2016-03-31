package org.company.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="dataFile")
public class DataFileDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  @XmlElement(name="dataRecord",type=DataRecordDTO.class)
  private List<DataRecordDTO> data = new ArrayList<DataRecordDTO>();
  
  private String name;

  public DataFileDTO(List<DataRecordDTO> records) {
    super();
    this.data=records; 
  }

  public DataFileDTO() {
    super();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<DataRecordDTO> getData() {
    return data;
  }

  public void setData(List<DataRecordDTO> dataFile) {
    this.data = dataFile;
  }
  
}
