package com.easysoft.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.easysoft.model.Shencha;

public interface ShenChaRepository extends MongoRepository<Shencha, String> {

}
