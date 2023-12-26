package com.omantourism.datamanager.repository;

import com.omantourism.datamanager.model.PhotoInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoInfoRepository extends JpaRepository<PhotoInfo, String> {
}
