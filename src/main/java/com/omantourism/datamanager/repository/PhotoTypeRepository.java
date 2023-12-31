package com.omantourism.datamanager.repository;

import com.omantourism.datamanager.model.PhotoType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoTypeRepository extends JpaRepository<PhotoType, Integer> {
}
