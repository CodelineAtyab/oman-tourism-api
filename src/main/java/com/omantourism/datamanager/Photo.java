package com.omantourism.datamanager;

public class Photo {
    public String id;
    public String label;
    public String description;
    public String path;

    public Photo(String id, String label, String description, String path) {
        this.id = id;
        this.label = label;
        this.description = description;
        this.path = path;
    }
}
