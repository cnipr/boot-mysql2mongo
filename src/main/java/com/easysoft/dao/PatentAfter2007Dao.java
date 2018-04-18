package com.easysoft.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.easysoft.model.PatentAfter20075730w;

@Transactional  @Repository
public interface PatentAfter2007Dao extends CrudRepository<PatentAfter20075730w, String> {
} 
