package com.hyunbin.demospringhateoas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.hateoas.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    @GetMapping("/hello")
    public Hello hell(){
        Hello hello = new Hello();
        hello.setPrefix("Hey,");
        hello.setName("hyunbin");

        return hello;
    }
}
