package com.newding.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newding.dao.ProductDao;
import com.newding.domain.Product;

@Controller
@RequestMapping("/")
public class ProductControlelr {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ProductDao productDao;
	
	
	@RequestMapping("/") 
	public String home() {
		logger.info(">>>> home controller"); 
		
		return "redirect:/list";
	} 
	
	

	@RequestMapping("/list")
	public @ResponseBody List<Product> list() {
		logger.info(">>> list Controller");

		List<Product> selList = productDao.selectUseraccount();
		for (Product useraccount : selList) {
			logger.info(useraccount.toString());

		}
		return selList;
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public @ResponseBody Product insert(@RequestParam(value = "tid") String tid,
			@RequestParam(value = "username") String username, @RequestParam(value = "pword") String pword) {
		logger.info(">>> insert Controller");

		Product ua = new Product();
		ua.setTid(tid);
		ua.setUsername(username);
		ua.setPword(pword);

		// TODO 예외처리 방법 정리할 것..
		int insertResult = productDao.insertUseraccount(ua);
		if (insertResult > 1) {
			logger.info("정상 등록되었습니다. result : {}", insertResult);
		}

		Product selUa = productDao.selectOneUseraccount(tid);

		logger.info("resut : {}", selUa.toString());

		return selUa;
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public @ResponseBody Product update(@RequestParam(value = "tid") String tid, 
			@RequestParam(value = "username") String username,@RequestParam(value = "pword") String pword) {
		logger.info(">>>> update controller");

		Product ua = new Product();
		ua.setTid(tid);
		ua.setUsername(username);
		ua.setPword(pword);
		
		productDao.updateUseraccount(ua);

		return productDao.selectOneUseraccount(tid); 
	}
	
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody Product delete(@RequestParam(value = "tid") String tid) {
		logger.info(">>>> delete controller");

		productDao.deleteUseraccount(tid);

		return productDao.selectOneUseraccount(tid); 
	}

	

}
