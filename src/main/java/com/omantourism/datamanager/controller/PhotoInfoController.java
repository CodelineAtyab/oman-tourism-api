package com.omantourism.datamanager.controller;

import com.omantourism.datamanager.model.Photo;
import com.omantourism.datamanager.service.PhotoInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/api/v1/photos")
public class PhotoInfoController {

    @Autowired
    PhotoInfoService photoInfoService;

    @GetMapping
    public List<Photo> getAllPhotos() {
        return photoInfoService.getPhotos();
    }

    @GetMapping(path = "/{photoId}")
    public Photo getSpecificPhoto(@PathVariable String photoId) {
        return photoInfoService.getPhoto(photoId);
    }

    @PostMapping
    public Photo addPhoto(@RequestBody Photo incomingPhoto){
        return photoInfoService.createPhoto(incomingPhoto);
    }

    @PutMapping(path = "/{photoId}")
    public Photo updatePhoto(@PathVariable String photoId, @RequestBody Photo incomingPhoto) {
        return photoInfoService.updatePhoto(photoId, incomingPhoto);
    }

    @DeleteMapping(path = "/{photoId}")
    public Photo removePhoto(@PathVariable String photoId) {
        return photoInfoService.deletePhoto(photoId);
    }
}
