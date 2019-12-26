package com.unisys.dojo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unisys.dojo.domain.Response;

@Repository
public interface ResponseRepository extends CrudRepository<Response, Long>{

}
