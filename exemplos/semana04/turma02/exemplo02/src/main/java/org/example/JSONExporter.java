package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONExporter {
    public String convertToJson(Object object) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        return gson.toJson(object);
    }
}
