package com.rinpo.eam.layblog.utils.security;

/**
 */
public class EncryptException extends RuntimeException {

    public EncryptException() {
        super();
    }

    public EncryptException(String message) {
        super(message);
    }

    public EncryptException(Throwable cause) {
        super(cause);
    }

    public EncryptException(String message, Throwable cause) {
        super(message, cause);
    }
}
