package com.omantourism.datamanager.model;

public class PhotoInfo {
    public String id;
    public String label;
    public String description;
    public String path;

    public PhotoInfo(String id, String label, String description, String path) {
        this.id = id;
        this.label = label;
        this.description = description;
        this.path = path;
    }
}
