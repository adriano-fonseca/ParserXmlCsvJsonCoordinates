package org.company.dto.gpx;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class TrkDTO {
  
  private String name;

  @XmlElement(name="trkseg",type=TrksegDTO.class)
  private List<TrksegDTO> trackSegmentList = new ArrayList<TrksegDTO>();

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<TrksegDTO> getTrackSegmentList() {
    return trackSegmentList;
  }

  public void setTrackSegmentList(List<TrksegDTO> trackSegmentList) {
    this.trackSegmentList = trackSegmentList;
  }

  @Override
  public String toString() {
    return "TrkDTO [trackPointList=" + trackSegmentList + "]";
  }
  
}
