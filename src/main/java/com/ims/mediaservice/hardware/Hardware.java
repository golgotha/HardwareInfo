package com.ims.mediaservice.hardware;

import com.ims.mediaservice.hardware.hdd.HardDrive;
import com.ims.mediaservice.hardware.motherboard.Motherboard;
import com.ims.mediaservice.hardware.network.NetworkAdapter;
import com.ims.mediaservice.hardware.processor.Processor;

/**
 * @author Valery Kantor
 *         mailto: valery.kantor@gmail.com
 */
public interface Hardware {

    Processor[] getProcessors();

    Motherboard getMotherboard();

    HardDrive getHardDrive();

    NetworkAdapter getNetworkAdapter();
}
