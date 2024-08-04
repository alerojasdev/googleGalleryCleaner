//package com.googlePhotosCleanner.cleanner_app.controller;
//
//
//import com.google.photos.types.proto.MediaItem;
//import com.googlePhotosCleanner.cleanner_app.service.PhotosAPI;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.oauth2.core.oidc.user.OidcUser;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.IOException;
//import java.util.List;
//
//@RestController
//public class RestPhotoAPI {
//
//    @Autowired
//    private PhotosAPI photosAPI;
//
//    @GetMapping("/photos")
//    public String getAllItems(@AuthenticationPrincipal OidcUser principal) throws IOException {
//        return photosAPI.getAllMediaItemsFromUser(principal.getName()).toString();
//    }
//}
