package com.homework.feature.downloader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;



class HttpStatusCheckerTest {
    HttpStatusChecker httpStatusChecker = new HttpStatusChecker();

    @Test
    public void testThatTestGetStatusImageWorks(){
        //Set up
        List<String> validUrl = new ArrayList<>();
        validUrl.add("https://http.cat/100");
        validUrl.add("https://http.cat/101");
        validUrl.add("https://http.cat/102");
        validUrl.add("https://http.cat/200");
        validUrl.add("https://http.cat/201");
        validUrl.add("https://http.cat/401");
        validUrl.add("https://http.cat/402");
        validUrl.add("https://http.cat/303");
        validUrl.add("https://http.cat/307");

        List<Integer> validInt = new ArrayList<>();
        validInt.add(100);
        validInt.add(101);
        validInt.add(102);
        validInt.add(200);
        validInt.add(201);
        validInt.add(401);
        validInt.add(402);
        validInt.add(303);
        validInt.add(307);


        //Assertion
        List<String> responseStrings = new ArrayList<>();
        for (int i = 0; i < validUrl.size(); i++) {
            String response = httpStatusChecker.getStatusImage(validInt.get(i));
            responseStrings.add(response);
        }

        Assertions.assertLinesMatch(validUrl, responseStrings);
    }


    @Test
    public void testThatStatusCheckerThrowException()  {
        //Set up
        int code = 10000;

        //Assertion
        Assertions.assertThrows(IllegalArgumentException.class, () -> httpStatusChecker.getStatusImage(code));

    }

}