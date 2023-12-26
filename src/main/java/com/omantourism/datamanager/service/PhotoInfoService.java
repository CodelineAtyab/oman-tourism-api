package com.omantourism.datamanager.service;

import com.omantourism.datamanager.model.PhotoInfo;
import com.omantourism.datamanager.repository.PhotoInfoRepository;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class PhotoInfoService {
    public CopyOnWriteArrayList<PhotoInfo> photoInfoCollection = new CopyOnWriteArrayList<>();

    @Autowired
    public PhotoInfoRepository photoInfoRepository;

    public List<PhotoInfo> getPhotos() {
        return photoInfoRepository.findAll();
    }

    public PhotoInfo getPhoto(Integer photoId) {
        PhotoInfo resultPhotoInfo = null;
        Optional<PhotoInfo> foundPhoto = photoInfoCollection.stream().filter((currPhotoInfo) -> {
            return currPhotoInfo.id == photoId;
        }).findFirst();

        if (foundPhoto.isPresent()) {
            resultPhotoInfo = foundPhoto.get();
        }

        return resultPhotoInfo;
    }

    public PhotoInfo createPhoto(PhotoInfo incomingPhotoInfo){
        photoInfoRepository.save(incomingPhotoInfo);
        return incomingPhotoInfo;
    }

    public PhotoInfo updatePhoto(Integer photoId, PhotoInfo incomingPhotoInfo) {
        PhotoInfo foundPhotoInfo = getPhoto(photoId);
        foundPhotoInfo.label = incomingPhotoInfo.label;
        foundPhotoInfo.description = incomingPhotoInfo.description;
        foundPhotoInfo.path = incomingPhotoInfo.path;
        return foundPhotoInfo;
    }

    public PhotoInfo deletePhoto(@PathVariable Integer photoId) {
        PhotoInfo foundPhotoInfo = getPhoto(photoId);
        photoInfoCollection.remove(foundPhotoInfo);
        return foundPhotoInfo;
    }
}
