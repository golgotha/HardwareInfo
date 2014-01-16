package com.ims.mediaservice.hardware;

import com.ims.mediaservice.hardware.network.NetworkAdapter;

/**
 * @author Valery Kantor
 *         mailto: valery.kantor@gmail.com
 */
public abstract class AbstractHardwareLayer implements Hardware {

    @Override
    public final NetworkAdapter getNetworkAdapter() {
        return new NetworkAdapter();
    }
}
