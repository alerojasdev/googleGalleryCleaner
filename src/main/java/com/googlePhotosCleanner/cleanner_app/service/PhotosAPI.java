package com.googlePhotosCleanner.cleanner_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class PhotosAPI {
    @Autowired
    WebClient webClient;
    public String getAllAlbumsInfoFromUser(){

        String resourceURI = "/albums";
        String body =
                webClient
                        .get()
                        .uri(uf ->
                                uf.path(resourceURI)
                                        .build()
                        )
                        .retrieve()
                        .bodyToMono(String.class)
                        .block();
        return body;

    }


}
