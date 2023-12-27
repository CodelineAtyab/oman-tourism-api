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
    public ResponseEntity<PhotoInfo> uploadContent(@RequestParam MultipartFile photoFile) throws IOException {
        PhotoInfo savedPhotoInfo = photoInfoService.createPhoto(new PhotoInfo());

        // Save the picture to the file system
        File destinationFile = new File("%s/%s.%s".formatted("./data", savedPhotoInfo.id, "jpg"));
        FileUtils.copyInputStreamToFile(photoFile.getInputStream(), destinationFile);

        // Once we have the auto gen ID from DB, we can now update the path and update the DB record.
        savedPhotoInfo.path = destinationFile.getPath();
        return ResponseEntity.ok(photoInfoService.createPhoto(savedPhotoInfo));
    }
}
