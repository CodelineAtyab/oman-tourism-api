package com.omantourism.datamanager.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class PhotoInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String label;
    public String description;
    public String path;

    @ManyToMany
    @JoinTable(
            name = "photo_info_photo_type_map",
            joinColumns = @JoinColumn(name = "photoinfo_id"),
            inverseJoinColumns = @JoinColumn(name = "phototype_id")
    )
    public Set<PhotoType> photoTypes;
}
