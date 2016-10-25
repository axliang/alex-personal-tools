package com.test.spring;

import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.test.domain.ExternalResponse;

/**
 * @Type UriComponentsBuilderDemo.java
 * @Desc 
 * @author alex
 * @date 2016年10月24日 下午5:11:21
 * @version 
 */
public class UriComponentsBuilderDemo {
    
    
    private UriComponentsBuilder targetUriBuilder = UriComponentsBuilder.fromUriString("http://127.0.0.1");

    public String getUrlString(String param, String value) {
        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("phoneNo", "12345678910");
        URI targetUri=  targetUriBuilder.path("/userinfo/{phoneNo}/userstatus").buildAndExpand(map).toUri();
        String targetUriStr = targetUri.toString();
       
        RestTemplateBuilder builder = new RestTemplateBuilder();
        RestTemplate restTemplate = builder.build();
        ExternalResponse response = restTemplate.getForObject(targetUri, ExternalResponse.class);
        
        return targetUriStr;
       
        
    }
    
    public void test2(){
        
        UriComponents targetUriComponents = UriComponentsBuilder.fromUriString(
                "http://example.com/hotels/{hotel}/bookings/{booking}").build();

        URI targetUri = targetUriComponents.expand("42", "21").encode().toUri();
        
    }
    
    public static void main(String[] args){
        UriComponentsBuilderDemo  demo =  new UriComponentsBuilderDemo();
        String url = demo.getUrlString("test", "test");
        System.out.println(url);
        
    }
    

}


/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2016年10月24日 alex creat
 */