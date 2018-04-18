package com.easysoft.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.easysoft.model.AppTbSearchHi;

@Transactional  @Repository
public interface AppTbSearchDao extends CrudRepository<AppTbSearchHi, String> {
	
} 
