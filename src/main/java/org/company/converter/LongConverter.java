package org.company.converter;

import org.jsefa.common.converter.SimpleTypeConverter;

import org.jsefa.common.converter.SimpleTypeConverter;

public class LongConverter implements SimpleTypeConverter {

  private static final LongConverter INSTANCE = new LongConverter();

  public static LongConverter create() {
    return INSTANCE;
  }

  private LongConverter() {
  }

  @Override
  public Object fromString(String s) {
    if (s != null) {
      return new Long(s);
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