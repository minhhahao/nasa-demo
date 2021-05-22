package com.requests;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.ResponseBody;

import java.io.FileWriter;
import java.io.IOException;

public class JavaHttpURLConnectionDemo {
    private static FileWriter file;

    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY")
                .method("GET", null)
                .addHeader("Content-Type", "application/json")
                .build();
        ResponseBody responseBody = client.newCall(request).execute().body();
        Gson gson = new Gson();
        NasaDemoEntity entity = gson.fromJson(responseBody.string(), NasaDemoEntity.class);
        saveToJsonFile(entity);
    }

    private static void saveToJsonFile(NasaDemoEntity entity) {
        try {
            file = new FileWriter("./nasaDemo.json");
            String entityNasaDemoString = new Gson().toJson(entity);
            file.write(entityNasaDemoString);
            System.out.println("Conplete store to nasaDemo.json!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                file.flush();
                file.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
