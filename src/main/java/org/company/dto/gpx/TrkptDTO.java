package org.company.dto.gpx;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class TrkptDTO {
  
  @XmlAttribute
  private BigDecimal lat;

  @XmlAttribute
  private BigDecimal lon;

  private BigDecimal ele;

  private Calendar   time;
  
  public TrkptDTO(BigDecimal lat, BigDecimal lon, BigDecimal ele, Calendar time) {
    super();
    this.lat = lat;
    this.lon = lon;
    this.ele = ele;
    this.time = time;
  }
  
  public TrkptDTO() {
    super();
  }
  
  

  public BigDecimal getLat() {
    return lat;
  }

  public void setLat(BigDecimal lat) {
    this.lat = lat;
  }

  public BigDecimal getLon() {
    return lon;
  }

  public void setLon(BigDecimal lon) {
    this.lon = lon;
  }

  public BigDecimal getEle() {
    return ele;
  }

  public void setEle(BigDecimal ele) {
    this.ele = ele;
  }

  public Calendar getTime() {
    return time;
  }

  public void setTime(Calendar time) {
    this.time = time;
  }

  @Override
  public String toString() {
    return "TrkptDTO [lat=" + lat + ", lon=" + lon + ", ele=" + ele + ", time=" + time + "]";
  }

}
