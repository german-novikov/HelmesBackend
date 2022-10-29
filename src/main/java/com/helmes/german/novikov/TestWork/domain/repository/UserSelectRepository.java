package com.helmes.german.novikov.TestWork.domain.repository;

import com.helmes.german.novikov.TestWork.domain.entity.UserSelect;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSelectRepository extends CrudRepository<UserSelect, Long> {
}
