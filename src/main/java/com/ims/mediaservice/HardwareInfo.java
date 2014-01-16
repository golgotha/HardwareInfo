package com.ims.mediaservice;

import com.ims.mediaservice.hardware.Hardware;
import com.ims.mediaservice.hardware.Hardware4Win;
import com.ims.mediaservice.hardware.network.NetworkAdapter;
import com.ims.mediaservice.hardware.processor.Processor;
import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.WinBase;

import java.io.*;

/**
 * @author Valery Kantor
 *         mailto: valery.kantor@gmail.com
 */
public class HardwareInfo {

    public static void main(String[] arg) throws OperationSystemNotSupportedException, IOException {
        System.out.println("Start app.");
        Hardware hardware;
        if (Platform.isWindows()) {
            hardware = new Hardware4Win();
        } else {
            throw new OperationSystemNotSupportedException();
        }

        FileOutputStream fos = new FileOutputStream("result.txt");
        System.setOut(new PrintStream(fos));
        for (Processor processor : hardware.getProcessors()) {
            System.out.println(String.format("Vendor: %s", processor.getVendor()));
            System.out.println(String.format("Identifier: %s", processor.getIdentifier()));
            System.out.println(String.format("Name: %s", processor.getName()));
            System.out.println("\n");
        }

        NetworkAdapter networkAdapter = hardware.getNetworkAdapter();
        System.out.println(String.format("IP address: %s", networkAdapter.getIpAddress()));
        System.out.println(String.format("MAC address: %s", networkAdapter.getMacAddress()));

        System.out.println(String.format("Motherboard serial number: %s", hardware.getMotherboard().getSerialNumber()));

        Kernel32 INSTANCE = (Kernel32) Native
            .loadLibrary("Kernel32", Kernel32.class);

        WinBase.SYSTEM_INFO systeminfo = new WinBase.SYSTEM_INFO();
        INSTANCE.GetSystemInfo(systeminfo);
        System.out.println("Processor Type : " + systeminfo.dwProcessorType);
        System.out.println("Number Of Processors : " + systeminfo.dwNumberOfProcessors);
        System.out.println("Hard Drive serial number : " + hardware.getHardDrive().getSerialNumber("C"));
        fos.close();
    }

}
