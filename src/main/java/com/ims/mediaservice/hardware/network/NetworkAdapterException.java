package com.ims.mediaservice.hardware.network;

/**
 * @author Valery Kantor
 *         mailto: valery.kantor@gmail.com
 */
public class NetworkAdapterException extends RuntimeException {
    public NetworkAdapterException() {
    }

    public NetworkAdapterException(String message) {
        super(message);
    }

    public NetworkAdapterException(String message, Throwable cause) {
        super(message, cause);
    }
}
