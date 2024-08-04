package com.googlePhotosCleanner.cleanner_app.service;

import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.OAuth2Credentials;
import com.google.photos.library.v1.PhotosLibraryClient;
import com.google.photos.library.v1.PhotosLibrarySettings;
import com.google.photos.library.v1.internal.InternalPhotosLibraryClient;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.StatusCode;
import com.google.photos.types.proto.MediaItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PhotosAPI {

    @Autowired// gestiona los clientes autorizados con oauth2. permite obtener informacion del cliente autorizado, como el token de acceso
    private OAuth2AuthorizedClientService authorizedClientService;

    @Autowired
    private ClientRegistrationRepository clientRegistrationRepository;

    private PhotosLibraryClient photosLibraryClient; // crea una instancia del cliente para interactuar con la api de google

    private PhotosLibraryClient createClientWithAccessToken(String accessToken) throws IOException {
        AccessToken token = new AccessToken(accessToken, null);
        OAuth2Credentials credentials = OAuth2Credentials.create(token);
        PhotosLibrarySettings settings = PhotosLibrarySettings.newBuilder()
                .setCredentialsProvider(() -> credentials)
                .build();
        return PhotosLibraryClient.initialize(settings);
    }

    public List<String> getAllMediaItemsFromUser(String principalName) throws IOException {
        OAuth2AuthorizedClient client = authorizedClientService.loadAuthorizedClient(
                clientRegistrationRepository.findByRegistrationId("google").getRegistrationId(), principalName);

        if (client != null) {
            String accessToken = client.getAccessToken().getTokenValue();
            photosLibraryClient = createClientWithAccessToken(accessToken);
            try {
                InternalPhotosLibraryClient.ListMediaItemsPagedResponse response = photosLibraryClient.listMediaItems();
//                List<MediaItem> mediaItems = new ArrayList<>();
                List<String> mediaItems = new ArrayList<>();
                for (MediaItem item : response.iterateAll()) {
                    mediaItems.add(item.getBaseUrl());
                }
                return mediaItems;
            } catch (ApiException e) {
                if (e.getStatusCode().getCode() == StatusCode.Code.UNAUTHENTICATED) {
                } else {
                    throw e;
                }
            }
        }
        return List.of();
    }
}
