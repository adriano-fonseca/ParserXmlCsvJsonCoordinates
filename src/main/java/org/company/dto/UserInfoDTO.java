package org.company.dto;

import org.company.converter.DoubleConverter;
import org.company.converter.ShortConverter;
import org.jsefa.csv.annotation.CsvDataType;
import org.jsefa.csv.annotation.CsvField;



@CsvDataType
public class UserInfoDTO {
  
  public UserInfoDTO(){
    super();
  }
  
  public UserInfoDTO(String userId, String userPassword, Short bloodType, Double altitude){
    super();
    this.userId=userId;
    this.userPassword=userPassword;
    this.bloodType=bloodType;
    this.altitude=altitude;
  }

 @CsvField(pos = 1)
 String userId;
 @CsvField(pos = 2)
 String userPassword;
 @CsvField(pos = 7, converterType = ShortConverter.class)
 Short bloodType;
 @CsvField(pos = 12, converterType = DoubleConverter.class)
 Double altitude;

}