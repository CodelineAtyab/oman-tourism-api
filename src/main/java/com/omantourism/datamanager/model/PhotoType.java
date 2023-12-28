package com.omantourism.datamanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

import java.util.Set;

@Entity
public class PhotoType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Pattern(regexp = "^[a-z|A-Z]+$")
    public String type;

    public PhotoType() {}

    public PhotoType(int id, String type) {
        this.id = id;
        this.type = type;
    }

    @ManyToMany(mappedBy = "photoTypes")
    @JsonIgnore
    public Set<PhotoInfo> photoInfos;
}
