package com.easysoft.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.easysoft.model.AppTbUser;

public interface AppTbUserRepository extends MongoRepository<AppTbUser, String> {

}
