package com.googlePhotosCleanner.cleanner_app.controller;

import com.googlePhotosCleanner.cleanner_app.service.PhotosAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerPhotosCleaner {

    @Autowired
    PhotosAPI photosAPI;

    @GetMapping("test/app")
    public String test(){

        String response = photosAPI.getAllAlbumsInfoFromUser();

        return response;
    }
}
