package com.easysoft.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.easysoft.model.AppTbChannel;

@Transactional  @Repository
public interface AppTbChannelDao extends CrudRepository<AppTbChannel, String> {
} 
