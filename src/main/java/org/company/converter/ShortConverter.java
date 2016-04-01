package org.company.converter;

import org.jsefa.common.converter.SimpleTypeConverter;

public class ShortConverter implements SimpleTypeConverter {

  private static final ShortConverter INSTANCE = new ShortConverter();

  public static ShortConverter create() {
    return INSTANCE;
  }

  private ShortConverter() {
  }

  @Override
  public Object fromString(String s) {
    if (s != null) {
      return new Short(s);
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