package com.easysoft.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.easysoft.model.AppTbSearchHi;

public interface AppTbSearchRepository extends MongoRepository<AppTbSearchHi, String> {

}
