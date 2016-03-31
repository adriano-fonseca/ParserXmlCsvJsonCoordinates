package org.company.dto.gpx;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class TrksegDTO {

  @XmlElement(name="trkpt",type=TrkptDTO.class)
  private List<TrkptDTO> trackPointList = new ArrayList<TrkptDTO>();

  public List<TrkptDTO> getTrackPointList() {
    return trackPointList;
  }

  public void setTrackPointList(List<TrkptDTO> trackPointList) {
    this.trackPointList = trackPointList;
  }

  @Override
  public String toString() {
    return "TrksegDTO [trackPointList=" + trackPointList + "]";
  }
}
