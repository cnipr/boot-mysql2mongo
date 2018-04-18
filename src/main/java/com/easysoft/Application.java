package com.easysoft;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import com.easysoft.dao.AppTbChannelDao;
import com.easysoft.dao.AppTbSearchDao;
import com.easysoft.dao.AppTbSearchHisDao;
import com.easysoft.dao.AppTbUserDao;
import com.easysoft.model.AppTbSearchHi;
import com.easysoft.repository.AppTbChannelRepository;
import com.easysoft.repository.AppTbSearchRepository;
import com.easysoft.repository.AppTbUserRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Autowired
	public JdbcTemplate jdbc;
	
	@Autowired
	private AppTbChannelRepository channelRepository;	
	@Autowired
	public AppTbChannelDao channelDao;
	
	@Autowired
	private AppTbUserRepository userRepository;	
	@Autowired
	public AppTbUserDao userDao;
	
	@Autowired
	private AppTbSearchRepository searchRepository;	
	@Autowired
	public AppTbSearchDao searchDao;
	@Autowired
	public AppTbSearchHisDao searchHisDao;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		long t1 = System.currentTimeMillis();
//		saveCsv();
//		saveSearchHisCsv();
//		saveSearchHisCsv2();
//		oracleToMongo();
//		testOracle();
//		pageSave();
		long t2 = System.currentTimeMillis();
		System.out.println("consume time:" + (t2 - t1) + "ms");
	}

	private void testOracle() {
//		pageSave();
//		System.out.println("用户数量:" + count);
//		List<AppTbSearchHi> list = searchHisDao.findByUsername("liuc", 5);
		List<AppTbSearchHi> list = searchHisDao.findFromTo(69390660, 69390667);
		for (Iterator<AppTbSearchHi> iterator = list.iterator(); iterator.hasNext();) {
			AppTbSearchHi appTbSearchHi = (AppTbSearchHi) iterator.next();
			System.out.println(appTbSearchHi.getUsername() + "\t" + appTbSearchHi.getTrsExp()); 
		}
	}

	private void pageSave() {
		int count = jdbc.queryForObject("select count(*) from APP_TB_SEARCH_HIS", Integer.class);
		int pageSize = 10000; 
		int pageNum = (count + pageSize - 1) / pageSize;
		for (int i = 0; i < pageNum; i++) {
			int from = pageSize*i;
			int to = pageSize*i+pageSize;
			to = to>count ? count : to;
			List<AppTbSearchHi> list = searchHisDao.findFromTo(from, to);
//			searchRepository.save(list);
			StreamSupport.stream(list.spliterator(), true).forEach(entity -> searchRepository.save(entity));
			System.out.println(new Date() + "\t 保存了" + to + "条数据");
		}
	}
	private void oracleToMongo() throws IOException {
//		searchHisRepository.deleteAll();
		
		//sequential
//		dao.findAll().forEach(entity -> searchHisRepository.save(entity));
		
		//parallel  可以提高速度
//		StreamSupport.stream(channelDao.findAll().spliterator(), true).forEach(entity -> channelRepository.save(entity));
//		StreamSupport.stream(userDao.findAll().spliterator(), true).forEach(entity -> userRepository.save(entity));
		Iterator<AppTbSearchHi> iterator = searchDao.findAll().iterator();
		while (iterator.hasNext()) {
			searchRepository.save(iterator.next());
		}
//		StreamSupport.stream(searchDao.findAll().spliterator(), false).forEach(entity -> searchRepository.save(entity));
		
//		StreamSupport.stream(channelDao.findAll().spliterator(), true).forEach(entity -> channelRepository.save(entity));
	}
}
