package com.omantourism.datamanager.service;

import com.omantourism.datamanager.model.PhotoInfo;
import com.omantourism.datamanager.model.PhotoInfoWithType;
import com.omantourism.datamanager.repository.PhotoInfoRepository;
import com.omantourism.datamanager.repository.PhotoTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class PhotoInfoService {
    @Autowired
    public PhotoInfoRepository photoInfoRepository;

    @Autowired
    public PhotoTypeRepository photoTypeRepository;

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

    public PhotoInfo updatePhoto(Integer photoId, PhotoInfoWithType incomingPhotoInfoWithType) {
        PhotoInfo foundPhotoInfo = getPhoto(photoId);
        foundPhotoInfo.label = incomingPhotoInfoWithType.photoInfo.label;
        foundPhotoInfo.description = incomingPhotoInfoWithType.photoInfo.description;
        foundPhotoInfo.photoType = photoTypeRepository.findById(incomingPhotoInfoWithType.photoTypeId).get();

        return photoInfoRepository.save(foundPhotoInfo);
    }

    public PhotoInfo deletePhoto(@PathVariable Integer photoId) {
        PhotoInfo foundPhotoInfo = getPhoto(photoId);
        photoInfoRepository.delete(foundPhotoInfo);
        return foundPhotoInfo;
    }
}
