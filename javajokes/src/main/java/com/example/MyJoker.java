package com.example;

import java.util.Random;

/**
 * Project: Build-It-Bigger
 * Package: com.example
 * Created by Simone Masini on 17/10/2015 at 12.39.
 */
public class MyJoker {

    public String getJoke(){
        Random random = new Random();
        return getJoke(random.nextInt(6));
    }

    private String getJoke(int index){
        switch (index){
            case 0:
                return "What did one computer say to the other?\n" +
                        "010101101010101010101";
            case 1:
                return "I named my hard drive \"dat ass,\" so once a month my computer asks if I want to \"back dat ass up.\"";
            case 2:
                return "What do computers eat for a snack? \n" +
                        "Microchips!";
            case 3:
                return "What did the spider do on the computer? \n" +
                        "Made a website!";
            case 4:
                return "I decided to make my password \"incorrect\" because if I type it in wrong, my computer will remind me, \"Your password is incorrect.\"";
            case 5:
                return "I put my phone on airplane mode, but it sure ain't flyin'";
            default:
                return "This is a funny joke!";
        }
    }
}
