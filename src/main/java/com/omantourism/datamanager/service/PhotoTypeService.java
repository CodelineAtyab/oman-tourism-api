package com.omantourism.datamanager.service;

import com.omantourism.datamanager.model.PhotoInfo;
import com.omantourism.datamanager.model.PhotoType;
import com.omantourism.datamanager.repository.PhotoTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoTypeService {
    @Autowired
    PhotoTypeRepository photoTypeRepository;

    public PhotoType getType(Integer id) { return photoTypeRepository.findById(id).get(); }

    public List<PhotoType> getAllTypes() { return photoTypeRepository.findAll(); }

    public PhotoType addType(PhotoType photoType) { return photoTypeRepository.save(photoType);}

    public PhotoType updateType(Integer id, PhotoType photoType) {
        PhotoType foundPhotoType = getType(id);
        foundPhotoType.type = photoType.type;
        return photoTypeRepository.save(foundPhotoType);
    }

    public PhotoType deleteType(Integer id) {
        PhotoType foundPhotoType = getType(id);
        photoTypeRepository.delete(foundPhotoType);
        return foundPhotoType;
    }
}
