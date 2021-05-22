package com.requests;

public class NasaDemoEntity {
    protected String date;
    protected String explanation;
    protected String hdurl;
    protected String media_type;
    protected String service_version;
    protected String title;
    protected String url;

    public NasaDemoEntity(String date,
                          String explanation,
                          String hdurl,
                          String media_type,
                          String service_version,
                          String title,
                          String url) {
        this.date = date;
        this.explanation = explanation;
        this.hdurl = hdurl;
        this.media_type = media_type;
        this.service_version = service_version;
        this.title = title;
        this.url = url;
    }
}
