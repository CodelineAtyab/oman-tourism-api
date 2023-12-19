package com.omantourism.datamanager;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/api/v1/photos")
public class ImageGeneratorController {
    CopyOnWriteArrayList<Photo> photoCollection = new CopyOnWriteArrayList<>();
    @GetMapping
    public List<Photo> getAllPhotos() {
        return photoCollection;
    }

    @GetMapping(path = "/{photoId}")
    public Photo getSpecificPhoto(@PathVariable String photoId) {
        Photo resultPhoto = null;
        Optional<Photo> foundPhoto = photoCollection.stream().filter((currPhoto) -> {
            return currPhoto.id.equals(photoId);
        }).findFirst();

        if (foundPhoto.isPresent()) {
            resultPhoto = foundPhoto.get();
        }

        return resultPhoto;
    }

    @PostMapping
    public Photo addPhoto(@RequestBody Photo incomingPhoto){
        photoCollection.add(incomingPhoto);
        return incomingPhoto;
    }

    @PutMapping(path = "/{photoId}")
    public Photo updatePhoto(@PathVariable String photoId, @RequestBody Photo incomingPhoto) {
        Photo foundPhoto = getSpecificPhoto(photoId);
        foundPhoto.label = incomingPhoto.label;
        foundPhoto.description = incomingPhoto.description;
        foundPhoto.path = incomingPhoto.path;
        return foundPhoto;
    }

    @DeleteMapping(path = "/{photoId}")
    public Photo removePhoto(@PathVariable String photoId) {
        Photo foundPhoto = getSpecificPhoto(photoId);
        photoCollection.remove(foundPhoto);
        return foundPhoto;
    }
}
