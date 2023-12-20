package com.omantourism.datamanager.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/v1/photoContent")
public class PhotoController {
    @GetMapping(path = "/{id}")
    public ResponseEntity<byte[]> getContent(@PathVariable String id) throws IOException {
        File myPic = new File("./data/aibohphobia.jpg");
        byte[] picContent = FileUtils.readFileToByteArray(myPic);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(picContent);
    }
}

