package com.omantourism.datamanager.controller;

import com.omantourism.datamanager.model.PhotoInfo;
import com.omantourism.datamanager.service.PhotoInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/photos")
public class PhotoInfoController {

    @Autowired
    PhotoInfoService photoInfoService;

    @GetMapping
    public List<PhotoInfo> getAllPhotos() {
        return photoInfoService.getPhotos();
    }

    @GetMapping(path = "/{photoId}")
    public PhotoInfo getSpecificPhoto(@PathVariable String photoId) {
        return photoInfoService.getPhoto(photoId);
    }

    @PostMapping
    public PhotoInfo addPhoto(@RequestBody PhotoInfo incomingPhotoInfo){
        return photoInfoService.createPhoto(incomingPhotoInfo);
    }

    @PutMapping(path = "/{photoId}")
    public PhotoInfo updatePhoto(@PathVariable String photoId, @RequestBody PhotoInfo incomingPhotoInfo) {
        return photoInfoService.updatePhoto(photoId, incomingPhotoInfo);
    }

    @DeleteMapping(path = "/{photoId}")
    public PhotoInfo removePhoto(@PathVariable String photoId) {
        return photoInfoService.deletePhoto(photoId);
    }
}
