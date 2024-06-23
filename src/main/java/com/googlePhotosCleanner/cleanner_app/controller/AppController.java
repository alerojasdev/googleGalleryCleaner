package com.googlePhotosCleanner.cleanner_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class AppController {

    @RequestMapping("photosCleaner/landingPage")
    public String landingPage(){
        return "landingPage";
    }

    @RequestMapping("photosCleaner/privacyPolicy") //for login page
    public String privacyPolicy(){
        return "privacyPolicy";
    }

    @RequestMapping("photosCleaner/termsOfService") //for login page
    public String termsOfService(){
        return "termsOfService";
    }
}
