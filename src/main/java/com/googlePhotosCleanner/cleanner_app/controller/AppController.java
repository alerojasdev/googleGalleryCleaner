package com.googlePhotosCleanner.cleanner_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

    @RequestMapping("test/app")
    public String test(){
        return "tested from gallery cleaner";
    }

    @RequestMapping("photosCleaner/landingPage")
    public String landingPage(){
        return "landingPage";
    }

    @RequestMapping("photosCleaner/privacyPolicy")
    public String privacyPolicy(){
        return "privacyPolicy";
    }

    @RequestMapping("photosCleaner/termsOfService")
    public String termsOfService(){
        return "termsOfService";
    }
}
