package com.newding.domain;

/**
 * 实体类:Product
 * 
 * @author admin
 *
 */
public class Product {
	private String tid;
	private String username;
	private String pword;

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPword() {
		return pword;
	}

	public void setPword(String pword) {
		this.pword = pword;
	}

	@Override
	public String toString() {
		return "Product [tid=" + tid + ", username=" + username + ", pword=" + pword + "]";
	}

}
