package com.omantourism.datamanager.controller;

import com.omantourism.datamanager.model.PhotoInfo;
import com.omantourism.datamanager.model.PhotoType;
import com.omantourism.datamanager.service.PhotoTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/api/v1/photoTypes")
public class PhotoTypeController {
    @Autowired
    public PhotoTypeService photoTypeService;

    @GetMapping
    public List<PhotoType> getAllPhotoTypes() {
        return photoTypeService.getAllTypes();
    }

    @GetMapping(path = "/{id}")
    public PhotoType getSpecificPhotoType(@PathVariable Integer id) {
        return photoTypeService.getType(id);
    }

    @PostMapping
    public PhotoType createPhotoType(@RequestBody PhotoType incomingPhotoType) {
        return photoTypeService.addType(incomingPhotoType);
    }

    @PutMapping(path = "/{id}")
    public PhotoType updatePhotoType(@PathVariable Integer id, @RequestBody PhotoType incomingPhotoType) {
        return photoTypeService.updateType(id, incomingPhotoType);
    }

    @DeleteMapping(path = "/{id}")
    public PhotoType removePhotoType(@PathVariable Integer id) {
        return photoTypeService.deleteType(id);
    }

}
