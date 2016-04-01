package org.company.converter;

import java.math.BigDecimal;

import org.jsefa.common.converter.SimpleTypeConverter;
import org.jsefa.common.converter.SimpleTypeConverter;

public class BigDecimalConverter implements SimpleTypeConverter {

  private static final BigDecimalConverter INSTANCE = new BigDecimalConverter();

  public static BigDecimalConverter create() {
    return INSTANCE;
  }

  private BigDecimalConverter() {
  }

  @Override
  public Object fromString(String s) {
    if (s != null) {
      return new BigDecimal(s);
    } else {
      return null;
    }
  }

  @Override
  public String toString(Object d) {
    if (d != null) {
      return d.toString();
    } else {
      return null;
    }
  }

}