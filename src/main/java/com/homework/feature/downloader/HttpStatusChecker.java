package com.homework.feature.downloader;


import org.jsoup.Jsoup;
import java.io.IOException;

public class HttpStatusChecker {

    public String getStatusImage(int code) {
        String baseUrl = "https://http.cat/";
        String completeUrl = baseUrl + code;
        //Jsoup throw exceptions automatically if page not found
        try {
            Jsoup.connect(completeUrl).ignoreContentType(true).timeout(10000).execute().body();
        }catch (IOException e){
            throw new IllegalArgumentException("Not valid code");
        }
        return completeUrl;
    }

}
