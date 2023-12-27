package com.omantourism.datamanager.model;

import jakarta.persistence.*;

@Entity
public class PhotoType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String type;

    public PhotoType() {}

    public PhotoType(int id, String type) {
        this.id = id;
        this.type = type;
    }

    @OneToOne(mappedBy = "photoType")
    public PhotoInfo photoInfo;
}
