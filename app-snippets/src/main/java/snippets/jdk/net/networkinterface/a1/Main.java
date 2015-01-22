package snippets.jdk.net.networkinterface.a1;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class Main {

    public static void main(String[] args) throws SocketException {
        Enumeration<NetworkInterface> nis = NetworkInterface.getNetworkInterfaces();
        while (nis.hasMoreElements()) {
            NetworkInterface ni = nis.nextElement();
            System.out.println("Display Name: " + ni.getDisplayName());
            System.out.println("Name: " + ni.getName());            
            
            byte[] mac = ni.getHardwareAddress();

            if(mac != null) {
                System.out.print("MAC address : ");

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < mac.length; i++) {
                    sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
                }
                System.out.println(sb.toString());
            }

            Enumeration<InetAddress> ips = ni.getInetAddresses();
            while (ips.hasMoreElements()) {
                InetAddress addr = ips.nextElement();

                System.out.println("Host Name: " + addr.getHostName());
                System.out.println("IP Address: " + addr.getHostAddress());
            }
            System.out.println();
        }
    }
}