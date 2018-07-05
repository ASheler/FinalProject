package com.glaserproject.joketeller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Teller {

    //init variable
    private List<String> jokes = new ArrayList<>();

    public String tellJoke (){



        //add jokes
        jokes.add("Why can't T-Rexes clap their hands?\n" +
                "Cause they're extinct.");
        jokes.add("My wife just asked me if I would change our 1 month old son.\n" +
                "I told her I liked the one we have.");
        jokes.add("The sweater my kids gave me last Christmas kept picking up static electricity, so I took it back to the store and exchanged it for another one…\n" +
                "...free of charge...");
        jokes.add("I bought some shoes from a drug dealer.\n" +
                "I don't know what he laced them with, but I was tripping all day");
        jokes.add("I would tell you something about your internal organs but...\n" +
                "...You wouldn't get it, it's an inside joke.");
        jokes.add("A median and a mode walk into a bar.\n" +
                "The bartender says, 'I'm glad you ditched your friend. He is mean.'");


        //get random number
        Random random = new Random();
        int i = random.nextInt(jokes.size());

        //return random joke
        return jokes.get(i);
    }

}
