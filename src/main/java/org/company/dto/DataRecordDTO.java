package org.company.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.Calendar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.jsefa.csv.annotation.CsvDataType;
import org.jsefa.csv.annotation.CsvField;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "record")
@CsvDataType
public class DataRecordDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  @XmlAttribute
  @CsvField(pos = 1)
  private Long       id;

  @CsvField(pos = 2)
  private String     vehicle;

  @XmlElement(name = "lat")
  @CsvField(pos = 3)
  private BigDecimal latitude;

  @XmlElement(name = "lon")
  @CsvField(pos = 4)
  private BigDecimal longitude;

  @CsvField(pos = 5)
  private Calendar   date;

  public DataRecordDTO() {
    super();
  }

  public DataRecordDTO(Long id, String vehicle, BigDecimal latitude, BigDecimal longitude, Calendar date) {
    super();
    this.id = id;
    this.vehicle = vehicle;
    this.latitude = latitude;
    this.longitude = longitude;
    this.date = date;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDateString() {
    DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
    return df.format(date.getTime());
  }

  public Calendar getDate() {
    return date;
  }

  public void setDateCalendar(Calendar dateCalender) {
    this.date = dateCalender;
  }

  public String getVehicle() {
    return vehicle;
  }

  public void setVehicle(String vehicle) {
    this.vehicle = vehicle;
  }

  public BigDecimal getLatitude() {
    return latitude;
  }

  public void setLatitude(BigDecimal latitude) {
    this.latitude = latitude;
  }

  public BigDecimal getLongitude() {
    return longitude;
  }

  public void setLongitude(BigDecimal longitude) {
    this.longitude = longitude;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    DataRecordDTO other = (DataRecordDTO) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "RecordDTO [id=" + id + ", vehicle=" + vehicle + ", latitude=" + latitude + ", longitude=" + longitude + ", date=" + date + "]";
  }

}
