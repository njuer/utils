package com.okaytech.encryption.error;

public class ApplicationException extends RuntimeException {
  private static final long serialVersionUID = -2997827932940692812L;

  public ApplicationException() {}

    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplicationException(Throwable cause) {
        super(cause);
    }

    public ApplicationException(String message, Throwable cause, boolean enableSuppression,
        boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
