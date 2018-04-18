package com.easysoft.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.easysoft.model.Shencha;

@Transactional  @Repository
public interface ShenChaDao extends PagingAndSortingRepository<Shencha, String> {
} 
