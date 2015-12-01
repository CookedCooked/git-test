package com.newding.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.newding.domain.Product;

public interface  ProductDao {

	// @Insert("INSERT into village(id,name,district) VALUES(#{vid},
	// #{villageName}, #{district})")

	@Insert("insert into product(tid, username, pword) value(#{tid}, #{username}, #{pword})")
	int insertUseraccount(Product product);
	
	@Select("select tid,username,pword from product") 	
	List<Product> selectUseraccount();   

	@Select("select username,pword from product where tid = #{tid}") 	
	Product selectOneUseraccount(String tid);   

	@Update("update product set username=#{username}, pword=#{pword} where tid = #{tid}")
	int updateUseraccount(Product product);

	@Delete("delete from product where tid = #{tid}") 
	void deleteUseraccount(String tid);

	

}
