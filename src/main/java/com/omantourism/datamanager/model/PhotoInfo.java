package com.omantourism.datamanager.model;

import jakarta.persistence.*;

@Entity
public class PhotoInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String label;
    public String description;
    public String path;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "photo_type_id", referencedColumnName = "id")
    public PhotoType photoType;
}
