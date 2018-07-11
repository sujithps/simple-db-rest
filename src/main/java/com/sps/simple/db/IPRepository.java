package com.sps.simple.db;

import com.sps.simple.model.IP;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPRepository extends CrudRepository<IP,Long> {
}
