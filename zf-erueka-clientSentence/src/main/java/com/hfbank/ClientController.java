package com.hfbank;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
public class ClientController {

    @Autowired
    DiscoveryClient client;

    @RequestMapping("/sentence")
    public  String getSentence() {
        return
                getWord("zf-erueka-client1") + " "
                        + getWord("zf-erueka-client2") + " "
                        + getWord("zf-erueka-client3") + " "
                        + getWord("zf-erueka-client4") + " "
                        + getWord("zf-erueka-client5") + "."
                ;//大小写不区分
    }

    public String getWord(String service) {
        List<ServiceInstance> list = client.getInstances(service);
        if (list != null && list.size() > 0 ) {
            URI uri = list.get(0).getUri();
            if (uri !=null ) {
                return (new RestTemplate()).getForObject(uri,String.class);
            }
        }
        return null;
    }
}