package com.shell.musicproject.services;

import com.squareup.okhttp.*;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DeezerServiceImpl implements DeezerService {
    private static final OkHttpClient httpClient = new OkHttpClient();
    private static final String DEEZER_HOST = "https://api.deezer.com/";
    private static final String ARTIST_SEARCH_PATH = "search?q=artist:";

    public void getArtists(String name) {
        String url = DEEZER_HOST + ARTIST_SEARCH_PATH + "\"" + name + "\"";
        Request request = new Request.Builder()
                .url(url)
                .build();
        System.out.println(url);

        try {
            Response response = httpClient.newCall(request).execute();
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            // Get response body
            System.out.println(response.body().string());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
