package com.sps.simple;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class IPController {

    @RequestMapping(method = RequestMethod.GET, path = "ip")
    public String getIP() throws UnknownHostException, InterruptedException {
        InetAddress inetAddress = InetAddress.getLocalHost();

        System.out.println("Received IP request & returning  : " + inetAddress.getHostAddress());

        Thread.sleep(10000);

        return "IP: " + inetAddress.getHostAddress();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String root() throws UnknownHostException {
        return "Call /ip to get ip of the machine.";
    }
}
