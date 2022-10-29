package com.helmes.german.novikov.TestWork.domain.repository;

import com.helmes.german.novikov.TestWork.domain.entity.Sector;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectorRepository extends CrudRepository<Sector, Long> {
}
