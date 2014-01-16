package com.ims.mediaservice.hardware;

import com.ims.mediaservice.hardware.hdd.HardDrive;
import com.ims.mediaservice.hardware.motherboard.Motherboard;
import com.ims.mediaservice.hardware.processor.Processor;

/**
 * @author Valery Kantor
 *         mailto: valery.kantor@gmail.com
 */
public class Hardware4OSX extends AbstractHardwareLayer {
    @Override
    public Processor[] getProcessors() {
        return new Processor[0];
    }

    @Override
    public Motherboard getMotherboard() {
        return null;
    }

    @Override
    public HardDrive getHardDrive() {
        return null;
    }
}
