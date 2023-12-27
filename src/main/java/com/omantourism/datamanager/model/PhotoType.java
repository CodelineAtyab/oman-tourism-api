package com.omantourism.datamanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    public PhotoInfo photoInfo;
}
