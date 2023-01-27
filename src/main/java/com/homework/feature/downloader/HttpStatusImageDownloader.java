package com.homework.feature.downloader;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class HttpStatusImageDownloader {
    public void downloadStatusImage(int code) {
        String url = new HttpStatusChecker().getStatusImage(code);
        String substring = url.substring(url.lastIndexOf("/") + 1);

        try {
            URL urlImage = new URL(url);
            InputStream in = urlImage.openStream();

            byte[] buffer = new byte[4096];
            int n;

            OutputStream os = new FileOutputStream("img/" + substring + ".jpg");

            while ((n = in.read(buffer)) != -1){
                os.write(buffer, 0, n);
            }

            os.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
