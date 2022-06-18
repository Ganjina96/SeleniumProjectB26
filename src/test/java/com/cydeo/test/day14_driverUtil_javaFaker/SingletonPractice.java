package com.cydeo.test.day14_driverUtil_javaFaker;

import org.testng.annotations.Test;

public class SingletonPractice {

    @Test
    public void singleton_understanding_test(){
        String word1 = Singleton.getWord();
        System.out.println("word1 = " + word1);

        String word2 = Singleton.getWord();
        System.out.println("word2 = " + word2);
    }
}
