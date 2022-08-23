package com.example.markdownconverter.controller;

import com.example.markdownconverter.model.MenuItem;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.stream.Collectors;

public interface FileHelper {

    static InputStream getFileFromResourceAsStream(String fileName) {
        ClassLoader classLoader = FileHelper.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }
    }

    static String generateMenuBasedOnFileNames(String urlPath) {
        ClassLoader classLoader = FileHelper.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(urlPath);
        try {
            var file = new String(inputStream.readAllBytes());
            String[] formatFileNameToArray = file.replace(".md", "").split("\n");
            var formatToMenuArray = Arrays.stream(formatFileNameToArray)
                    .map(fileName -> new MenuItem(capitalizeFirstChar(fileName), "pub/" + fileName, "pub"))
                    .collect(Collectors.toList());
            return new Gson().toJson(formatToMenuArray);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static String capitalizeFirstChar(String str) {
        if (str == null || str.length() <= 1) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

}
