package com.omantourism.datamanager.controller;

import com.omantourism.datamanager.model.PhotoInfo;
import com.omantourism.datamanager.service.PhotoInfoService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/v1/photoContent")
public class PhotoController {

    @Autowired
    PhotoInfoService photoInfoService;

    @GetMapping(path = "/{photoFileId}")
    public ResponseEntity<byte[]> getContent(@PathVariable String photoFileId) throws IOException {
        File myPic = new File("./data/%s.jpg".formatted(photoFileId));
        byte[] picContent = FileUtils.readFileToByteArray(myPic);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(picContent);
    }

    @PostMapping
    public ResponseEntity<PhotoInfo> uploadContent(@RequestParam MultipartFile photoFile,
                                           @RequestParam String photoFileId) throws IOException {
        File destinationFile = new File("%s/%s.%s".formatted("./data", photoFileId, "jpg"));
        FileUtils.copyInputStreamToFile(photoFile.getInputStream(), destinationFile);
        PhotoInfo photoInfo = new PhotoInfo();
        photoInfo.label = null;
        photoInfo.description = null;
        photoInfo.path = destinationFile.getPath();
        photoInfoService.createPhoto(photoInfo);
        return ResponseEntity.ok(photoInfo);
    }
}

