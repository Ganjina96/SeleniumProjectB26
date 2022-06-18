package com.cydeo.test.day13_configuration_reader;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadingProperties {

    @Test
    public void reading_from_properties_file() throws IOException {
        // Create Properties class' object in order to use the class' getProperty("key") method
        Properties properties = new Properties();

        //Create FileInputStream object to open file as a stream in Java memory
        FileInputStream file = new FileInputStream("configuration.properties");

        //Load "properties" object with the "file" we opened using FileInputStream
        properties.load(file);

        //We can use properties.getProperty method to read from the file we loaded
        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));
        System.out.println("properties.getProperty(\"username\") = " + properties.getProperty("username"));

    }
}
