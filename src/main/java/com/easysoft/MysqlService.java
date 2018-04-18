package com.easysoft;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

import com.easysoft.dao.PatentAfter2007Dao;
import com.easysoft.dao.ShenChaDao;
import com.easysoft.model.PatentAfter20075430w;
import com.easysoft.model.PatentAfter20075530w;
import com.easysoft.model.PatentAfter20075630w;
import com.easysoft.repository.PatentAfter2007Repository;
import com.easysoft.repository.ShenChaRepository;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

@SpringBootApplication
public class MysqlService implements CommandLineRunner {
	@Autowired
	public JdbcTemplate jdbc;
	
	@Autowired
	public MongoTemplate mongoTemplate; 
	
	@Autowired
	public PatentAfter2007Dao searchDao;
	@Autowired
	private PatentAfter2007Repository searchRepository;	
	
	@Autowired
	public ShenChaDao shenchaDao;
	@Autowired
	private ShenChaRepository shenchaRepository;

	private int processedCount;	

	public static void main(String[] args) {
		SpringApplication.run(MysqlService.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		long t1 = System.currentTimeMillis();
		mysqlToMongo2();
//		testMongo();
		long t2 = System.currentTimeMillis() -t1;
		System.out.println("consume time:" + t2 + "ms");
	}
	
	private void testMysql() {
		int count = jdbc.queryForObject("SELECT count(0) FROM patent_after_2007", Integer.class);
		System.out.println(count);
	}
	
	private void testMongo() {
		long count = mongoTemplate.getCollection("patentAfter20075730w").count();
		System.out.println(count);
		HashMap testmap = new HashMap();
		testmap.put("an","CN21085555.3");
		testmap.put("shencha","{'data':'操作成功'}");
//		mongoTemplate.save(testmap); 
		Mongo mongo = new Mongo("localhost", 27017);
		DB db = mongo.getDB("cnipr");
		DBCollection collection = db.getCollection("testmap");
		collection.insert((DBObject)testmap);
	}
	
	private void mysqlToMongo() throws IOException {
		//parallel  可以提高速度
		StreamSupport.stream(searchDao.findAll().spliterator(), true).forEach(entity -> searchRepository.save(entity));
	}
	
	/**
	 * 速度卡在mysql查询上，不靠谱
	 * @throws IOException
	 */
	private void mysqlToMongo1() throws IOException {
		//parallel  可以提高速度
//		StreamSupport.stream(shenchaDao.findAll().spliterator(), true).forEach(entity -> shenchaRepository.save(entity));
		int count = jdbc.queryForObject("SELECT count(0) FROM shencha", Integer.class);
		int size = 10000;
		int pageTotal = (count+size-1) / size;
		for (int pageIndex = 0; pageIndex < pageTotal; pageIndex++) {
			Pageable page = new PageRequest(pageIndex,size);//使用分页查询来防止内存溢出
			StreamSupport.stream(shenchaDao.findAll(page).spliterator(), true).forEach(entity -> {
				shenchaRepository.save(entity);
				processedCount++;
				if (processedCount % 1000 == 0) {
					System.out.println(new Date() + "insert count:" + processedCount);
				}
			});
		}
	}
	
	/**
	 * 把多个同构的mysql表中的数据入库到一个mongo表中	  
	 * @throws IOException
	 */
	private void mysqlToMongo2() throws IOException {
		//parallel  可以提高速度
		for (int i = 0; i < tables.length; i++) {
			StreamSupport.stream(jdbc.queryForList("select * from " + tables[i]).spliterator(), true)
			.forEach(entity -> {
				if (entity != null) {
					mongoTemplate.save(entity,"shencha");
					processedCount++;
					if (processedCount % 10000 == 0) {
						System.out.println(new Date() + "insert count:" + processedCount);
					}
				}
			});
			System.out.println(new Date() + "finish table:" + tables[i]);
		}
	}
	
	private void mysqlToMongo9() throws IOException {
		//parallel  可以提高速度
		StreamSupport.stream(searchDao.findAll().spliterator(), true).forEach(entity -> {
			Map map = new HashMap();
			map.put("an", entity.getAn());
			String shencha = entity.getShencha();
			if (shencha != null) {
				//通过字符串，获得最外部的json对象
				org.json.JSONObject jsonObj=new org.json.JSONObject(shencha);
		        //通过属性名，获得内部的对象
		        org.json.JSONObject total =jsonObj.getJSONObject("total");
		        org.json.JSONObject pageSize =jsonObj.getJSONObject("pageSize");
		        map.put("total", Integer.parseInt(total.toString()));
		        map.put("pageSize", Integer.parseInt(pageSize.toString()));
		        org.json.JSONObject datalist =jsonObj.getJSONObject("datalist");
		        //获得json对象组
		        org.json.JSONArray datalistArr = datalist.getJSONArray("datalist");
		        map.put("datalist", datalistArr);
			}
	        mongoTemplate.save(map);
		});
	}
	
	private String[] tables = {
			"patent_after_2007_01_341998",
			"patent_after_2007_02_265198",
			"patent_after_2007_03_416290",
			"patent_after_2007_04_461220",
			"patent_after_2007_05_242979",
			"patent_after_2007_06_513700",
			"patent_after_2007_07_86300",
			"patent_after_2007_08_30w",
			"patent_after_2007_09_379137",
			"patent_after_2007_10_20863",
			"patent_after_2007_11_30w",
			"patent_after_2007_12_30w",
			"patent_after_2007_13_30w",
			"patent_after_2007_14_30w",
			"patent_after_2007_15_30w",
			"patent_after_2007_16_30w",
			"patent_after_2007_17_30w",
			"patent_after_2007_18_30w",
			"patent_after_2007_19_30w",
			"patent_after_2007_20_30w",
			"patent_after_2007_21_30w",
			"patent_after_2007_22_30w",
			"patent_after_2007_23_30w",
			"patent_after_2007_24_30w",
			"patent_after_2007_25_30w",
			"patent_after_2007_26_30w",
			"patent_after_2007_27_30w",
			"patent_after_2007_28_30w",
			"patent_after_2007_29_30w",
			"patent_after_2007_30_30w",
			"patent_after_2007_31_30w",
			"patent_after_2007_32_30w",
			"patent_after_2007_33_30w",
			"patent_after_2007_34_30w",
			"patent_after_2007_35_30w",
			"patent_after_2007_36_30w",
			"patent_after_2007_37_30w",
			"patent_after_2007_38_30w",
			"patent_after_2007_39_30w",
			"patent_after_2007_40_30w",
			"patent_after_2007_41_30w",
			"patent_after_2007_42_30w",
			"patent_after_2007_43_30w",
			"patent_after_2007_44_30w",
			"patent_after_2007_45_30w",
			"patent_after_2007_46_30w",
			"patent_after_2007_47_30w",
			"patent_after_2007_48_30w",
			"patent_after_2007_49_30w",
			"patent_after_2007_50_30w",
			"patent_after_2007_51_30w",
			"patent_after_2007_52_30w",
			"patent_after_2007_53_30w",
			"patent_after_2007_54_30w",
			"patent_after_2007_55_30w",
			"patent_after_2007_56_30w",
			"patent_after_2007_57_30w"
		};
}
