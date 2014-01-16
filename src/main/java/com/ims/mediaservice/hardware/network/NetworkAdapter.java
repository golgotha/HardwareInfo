package com.ims.mediaservice.hardware.network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;

/**
 * @author Valery Kantor
 *         mailto: valery.kantor@gmail.com
 */
public class NetworkAdapter {
    private NetworkInterface network;

    private InetAddress ip;

    public NetworkAdapter() {
        try {
            ip = InetAddress.getLocalHost();
            this.network = NetworkInterface.getByInetAddress(ip);
        } catch (IOException e) {
            throw new NetworkAdapterException(e.getMessage(), e);
        }
    }

    public String getMacAddress() {
        try {
            byte[] mac = network.getHardwareAddress();
            StringBuilder sb = new StringBuilder();
            for (int i = 0, macLength = mac.length; i < macLength; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            return sb.toString();
        } catch (SocketException e) {
            throw new NetworkAdapterException(e.getMessage(), e);
        }
    }

    public String getIpAddress() {
        return ip.getHostAddress();
    }
}
