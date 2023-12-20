package com.omantourism.datamanager.service;

import com.omantourism.datamanager.model.Photo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class PhotoInfoService {
    public CopyOnWriteArrayList<Photo> photoCollection = new CopyOnWriteArrayList<>();

    public List<Photo> getPhotos() {
        return photoCollection;
    }

    public Photo getPhoto(String photoId) {
        Photo resultPhoto = null;
        Optional<Photo> foundPhoto = photoCollection.stream().filter((currPhoto) -> {
            return currPhoto.id.equals(photoId);
        }).findFirst();

        if (foundPhoto.isPresent()) {
            resultPhoto = foundPhoto.get();
        }

        return resultPhoto;
    }

    public Photo createPhoto(Photo incomingPhoto){
        photoCollection.add(incomingPhoto);
        return incomingPhoto;
    }

    public Photo updatePhoto(String photoId, Photo incomingPhoto) {
        Photo foundPhoto = getPhoto(photoId);
        foundPhoto.label = incomingPhoto.label;
        foundPhoto.description = incomingPhoto.description;
        foundPhoto.path = incomingPhoto.path;
        return foundPhoto;
    }

    public Photo deletePhoto(@PathVariable String photoId) {
        Photo foundPhoto = getPhoto(photoId);
        photoCollection.remove(foundPhoto);
        return foundPhoto;
    }
}
