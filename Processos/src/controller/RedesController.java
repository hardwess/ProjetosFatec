package controller;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class RedesController {

    public String ip() {
        String ip = "";
        String nome = "";
        String so = System.getProperty("os.name");
        Enumeration nis = null;
        try {
            nis = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        while (nis.hasMoreElements()) {
            NetworkInterface ni = (NetworkInterface) nis.nextElement();
            Enumeration ias = ni.getInetAddresses();
            while (ias.hasMoreElements()) {
                InetAddress ia = (InetAddress) ias.nextElement();
                if (ia.getHostAddress().contains("10.132")) { //Nesse if está a charada, sendo que eu sei que meu ip começa com 10.132, por exemplo
                    ip = ia.getHostAddress();
                }
                System.out.println("Teste " + ia.getHostAddress());
            }
        }
        System.out.println("Nome: " + nome);
        System.out.println("IP: " + ip);
        return so;
    }

    public double ping() {
        double i = 0.0;
        return i;
    }

}
