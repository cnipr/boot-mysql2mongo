package com.easysoft.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.easysoft.model.AppTbUser;

@Transactional  @Repository
public interface AppTbUserDao extends CrudRepository<AppTbUser, String> {
} 
