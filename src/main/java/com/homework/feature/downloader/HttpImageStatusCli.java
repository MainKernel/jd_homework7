package com.homework.feature.downloader;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class HttpImageStatusCli {

    public void runCLI() {
            System.out.println("This program download images of Http error codes");
            System.out.println("To download image enter error code");
            downloadImg();
    }

    private void downloadImg() {
        HttpStatusImageDownloader httpStatusImageDownloader = new HttpStatusImageDownloader();
        int code = 0;
        Scanner in = new Scanner(System.in);
        try {
            code = in.nextInt();
        } catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("Enter valid number");
        }

        try {
            httpStatusImageDownloader.downloadStatusImage(code);
            System.out.println("Image downloaded to img/" + code + ".jpg");
        } catch (IllegalArgumentException e) {
            System.out.println("Not error code found");
        }
    }


    public static void main(String[] args) {
        HttpImageStatusCli cli = new HttpImageStatusCli();
        cli.runCLI();
    }
}
