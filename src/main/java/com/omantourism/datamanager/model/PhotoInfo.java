package com.omantourism.datamanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PhotoInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String label;
    public String description;
    public String path;

//    public PhotoInfo(String id, String label, String description, String path) {
//        this.id = id;
//        this.label = label;
//        this.description = description;
//        this.path = path;
//    }
}
