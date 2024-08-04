package com.googlePhotosCleanner.cleanner_app.controller;

import com.googlePhotosCleanner.cleanner_app.service.PhotosAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.io.IOException;
import java.util.List;

@Controller
public class AppController {

    @Autowired
    PhotosAPI photosAPI;
    @GetMapping("/photos")
    public String getPhotos(Model model, @AuthenticationPrincipal OidcUser principal) throws IOException {
        List<String> imageUrls = photosAPI.getAllMediaItemsFromUser(principal.getName());
        System.out.println(" ");
        System.out.println("-----------------------------------------------------------");
        System.out.println(imageUrls);
        System.out.println("-----------------------------------------------------------");
        System.out.println(" ");
        model.addAttribute("imageUrls", imageUrls);
        return "visualizer";
    }
}
