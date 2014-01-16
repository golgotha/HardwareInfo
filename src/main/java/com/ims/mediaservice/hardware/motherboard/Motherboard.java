package com.ims.mediaservice.hardware.motherboard;

import java.io.IOException;

/**
 * @author Valery Kantor
 *         mailto: valery.kantor@gmail.com
 */
public interface Motherboard {
    String getSerialNumber() throws IOException;
}
