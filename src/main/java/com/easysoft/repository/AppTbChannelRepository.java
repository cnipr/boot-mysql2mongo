package com.easysoft.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.easysoft.model.AppTbChannel;

public interface AppTbChannelRepository extends MongoRepository<AppTbChannel, String> {

}
