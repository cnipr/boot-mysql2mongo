package com.easysoft.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.easysoft.model.AppTbSearchHi;

@Transactional  @Repository
public interface AppTbSearchHisDao extends JpaRepository<AppTbSearchHi, String> {
	/**
	 * 使用原生的sql查询
	 * @param username
	 * @param rownum
	 * @return
	 */
	@Query(value="select * from app_tb_search_his where username=? and rownum <= ?", nativeQuery = true)
	List<AppTbSearchHi> findByUsername(String username, int rownum);
	
	
	@Query(value="select * from app_tb_search_his where rownum <= ?", nativeQuery = true)
	List<AppTbSearchHi> findLimit(String username, int rownum);
	
	
	@Query(value="select * from (select A.*, rownum rn from app_tb_search_his A where rownum <= ?2) where rn > ?1", nativeQuery = true)
	List<AppTbSearchHi> findFromTo(int from,int to);
} 
