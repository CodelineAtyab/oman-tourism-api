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
    @Autowired
    public PhotoInfoRepository photoInfoRepository;

    public List<PhotoInfo> getPhotos() {
        return photoInfoRepository.findAll();
    }

    public PhotoInfo getPhoto(Integer photoId) {
        Optional<PhotoInfo> foundPhotoInfo = photoInfoRepository.findById(photoId);
        PhotoInfo resultPhotoInfo = null;
        if (foundPhotoInfo.isPresent()) {
            resultPhotoInfo = foundPhotoInfo.get();
        }
        return resultPhotoInfo;
    }

    public PhotoInfo createPhoto(PhotoInfo incomingPhotoInfo){
        return photoInfoRepository.save(incomingPhotoInfo);
    }

    public PhotoInfo updatePhoto(Integer photoId, PhotoInfo incomingPhotoInfo) {
        PhotoInfo foundPhotoInfo = getPhoto(photoId);
        foundPhotoInfo.label = incomingPhotoInfo.label;
        foundPhotoInfo.description = incomingPhotoInfo.description;
        foundPhotoInfo.photoType = null;

        // TODO: Extract PhotoType id from the wrapper object, find the PhotoType Object from repo and then link
        // the foundPhotoInfo.photoType = whatevertheobjis;

        return photoInfoRepository.save(foundPhotoInfo);
    }

    public PhotoInfo deletePhoto(@PathVariable Integer photoId) {
        PhotoInfo foundPhotoInfo = getPhoto(photoId);
        photoInfoRepository.delete(foundPhotoInfo);
        return foundPhotoInfo;
    }
}
