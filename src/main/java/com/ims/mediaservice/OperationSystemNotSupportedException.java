package com.ims.mediaservice;

/**
 * @author Valery Kantor
 *         mailto: valery.kantor@gmail.com
 */
public class OperationSystemNotSupportedException extends Exception {
    public OperationSystemNotSupportedException() {
    }

    public OperationSystemNotSupportedException(String message) {
        super(message);
    }

    public OperationSystemNotSupportedException(String message, Throwable cause) {
        super(message, cause);
    }
}
