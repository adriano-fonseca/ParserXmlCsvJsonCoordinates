package org.company.dto.gpx;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "gpx")
@XmlAccessorType(XmlAccessType.FIELD)
public class GpxDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  @XmlElement(name="trk",type=TrkDTO.class)
  private List<TrkDTO> trk = new ArrayList<TrkDTO>();
  
  public GpxDTO(List<TrkDTO> records) {
    super();
    this.trk=records; 
  }

  public GpxDTO() {
    super();
  }

  public List<TrkDTO> getTrk() {
    return trk;
  }

  public void setTrk(List<TrkDTO> dataFile) {
    this.trk = dataFile;
  }

  @Override
  public String toString() {
    return "GpxDTO [trk=" + trk + "]";
  }
}
