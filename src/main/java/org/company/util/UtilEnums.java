package org.company.util;


public class UtilEnums {
  public enum CoordinateType {
  
    LATITUDE("Lat", "Latitude"), LONGITUDE("Lon", "Longitude");
  
    private final String id;
  
    private final String value;
  
    CoordinateType(String id, String value) {
      this.id = id;
      this.value = value;
    }
  
    public String getId() {
      return id;
    }
  
    public String getValue() {
      return value;
    }
  }
  
  public enum FileType {
    
    XML("XML", "Extensible Markup Language"), JSON("json", "JavaScript Object Notation");
  
    private final String id;
  
    private final String value;
  
    FileType(String id, String value) {
      this.id = id;
      this.value = value;
    }
  
    public String getId() {
      return id;
    }
  
    public String getValue() {
      return value;
    }
  }
  
}