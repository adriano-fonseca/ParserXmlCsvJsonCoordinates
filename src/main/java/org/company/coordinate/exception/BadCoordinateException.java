package org.company.coordinate.exception;

public class BadCoordinateException extends RuntimeException {
  
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public BadCoordinateException(String message) {
    super(message);
  }
}
