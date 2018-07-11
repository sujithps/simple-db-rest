package com.sps.simple;

import com.sps.simple.db.IPRepository;
import com.sps.simple.model.IP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalTime;

@RestController
public class IPController {

    @Autowired
    IPRepository ipRepository;

    @RequestMapping(method = RequestMethod.GET, path = "ip")
    public String getIP() throws UnknownHostException, InterruptedException {
        InetAddress inetAddress = InetAddress.getLocalHost();

        String hostAddress = inetAddress.getHostAddress();

        System.out.println("Received IP request and returning  : " + hostAddress);

        IP ip = new IP();
        ip.setIp(hostAddress);
        ip.setTime(LocalTime.now().toString());
        ipRepository.save(ip);

        return "IP: " + hostAddress;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<IP> root() throws UnknownHostException {
        return ipRepository.findAll();
    }
}
