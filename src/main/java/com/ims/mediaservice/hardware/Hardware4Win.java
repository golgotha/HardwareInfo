package com.ims.mediaservice.hardware;

import com.ims.mediaservice.hardware.hdd.HardDrive;
import com.ims.mediaservice.hardware.hdd.HardDrive4Win;
import com.ims.mediaservice.hardware.motherboard.Motherboard;
import com.ims.mediaservice.hardware.motherboard.Motherboard4Win;
import com.ims.mediaservice.hardware.processor.CentralProcessor;
import com.ims.mediaservice.hardware.processor.Processor;
import com.sun.jna.platform.win32.Advapi32Util;
import com.sun.jna.platform.win32.WinReg;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Valery Kantor
 *         mailto: valery.kantor@gmail.com
 */
public class Hardware4Win extends AbstractHardwareLayer {
    private List<Processor> processors;
    @Override
    public Processor[] getProcessors() {
        if (processors == null) {
            final String cpuRegistryRoot = "HARDWARE\\DESCRIPTION\\System\\CentralProcessor";
            processors = new ArrayList<Processor>();
            String[] processorIds = Advapi32Util.registryGetKeys(WinReg.HKEY_LOCAL_MACHINE, cpuRegistryRoot);
            for(String processorId : processorIds) {
                String cpuRegistryPath = cpuRegistryRoot + "\\" + processorId;

                String vendor = Advapi32Util.registryGetStringValue(WinReg.HKEY_LOCAL_MACHINE,
                    cpuRegistryPath, "VendorIdentifier");
                String indentifier = Advapi32Util.registryGetStringValue(WinReg.HKEY_LOCAL_MACHINE,
                    cpuRegistryPath, "Identifier");
                String name = Advapi32Util.registryGetStringValue(WinReg.HKEY_LOCAL_MACHINE,
                    cpuRegistryPath, "ProcessorNameString");

                CentralProcessor cpu = new CentralProcessor.Builder()
                    .setVendor(vendor)
                    .setIdentifier(indentifier)
                    .setName(name)
                    .build();
                processors.add(cpu);
            }
        }

        return processors.toArray(new Processor[0]);
    }

    @Override
    public Motherboard getMotherboard() {
        return new Motherboard4Win();
    }

    @Override
    public HardDrive getHardDrive() {
        return new HardDrive4Win();
    }
}
