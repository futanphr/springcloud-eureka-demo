package com.hfbank;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
public class RibbonController {

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @RequestMapping("/ribbonSentence")
    public  String getSentence() {
        return
//                getWord("zf-erueka-client1") + " "
//                        + getWord("zf-erueka-client2") + " "
//                        + getWord("zf-erueka-client3") + " "
//                        + getWord("zf-erueka-client4") + " "
//                        + 
getWord("zf-erueka-client5") + "."
                ;//大小写不区分
    }

    public String getWord(String serviceId) {
        ServiceInstance serviceInstance = loadBalancerClient.choose(serviceId);
        System.out.println(serviceInstance.getUri());
        return (new RestTemplate()).getForObject(serviceInstance.getUri(),String.class);
    }
}