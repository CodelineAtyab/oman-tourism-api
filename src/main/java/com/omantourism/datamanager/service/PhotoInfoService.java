package com.omantourism.datamanager.service;

import com.omantourism.datamanager.model.PhotoInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class PhotoInfoService {
    public CopyOnWriteArrayList<PhotoInfo> photoInfoCollection = new CopyOnWriteArrayList<>();

    public List<PhotoInfo> getPhotos() {
        return photoInfoCollection;
    }

    public PhotoInfo getPhoto(String photoId) {
        PhotoInfo resultPhotoInfo = null;
        Optional<PhotoInfo> foundPhoto = photoInfoCollection.stream().filter((currPhotoInfo) -> {
            return currPhotoInfo.id.equals(photoId);
        }).findFirst();

        if (foundPhoto.isPresent()) {
            resultPhotoInfo = foundPhoto.get();
        }

        return resultPhotoInfo;
    }

    public PhotoInfo createPhoto(PhotoInfo incomingPhotoInfo){
        photoInfoCollection.add(incomingPhotoInfo);
        return incomingPhotoInfo;
    }

    public PhotoInfo updatePhoto(String photoId, PhotoInfo incomingPhotoInfo) {
        PhotoInfo foundPhotoInfo = getPhoto(photoId);
        foundPhotoInfo.label = incomingPhotoInfo.label;
        foundPhotoInfo.description = incomingPhotoInfo.description;
        foundPhotoInfo.path = incomingPhotoInfo.path;
        return foundPhotoInfo;
    }

    public PhotoInfo deletePhoto(@PathVariable String photoId) {
        PhotoInfo foundPhotoInfo = getPhoto(photoId);
        photoInfoCollection.remove(foundPhotoInfo);
        return foundPhotoInfo;
    }
}
