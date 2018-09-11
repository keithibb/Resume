package com.revature.model;

import java.sql.Timestamp;

public class ReimObj {
	private static int id;
	static double amount;
	private Timestamp submit;
	private Timestamp resolve;
	static String desc;
	 private String Author;
	private static String Resolver;
	private int rs_id;
	static int rt_id;
	
	public ReimObj() {}
	public static int getId() {
		return id;
	}
	public static void setId(int id) {
		ReimObj.id = id;
	}
	public static double getAmount() {
		return amount;
	}
	public static void setAmount(double amount) {
		ReimObj.amount = amount;
	}
	public Timestamp getSubmit() {
		return submit;
	}
	public void setSubmit(Timestamp submit) {
		this.submit = submit;
	}
	public Timestamp getResolve() {
		return resolve;
	}
	public void setResolve(Timestamp resolve) {
		this.resolve = resolve;
	}
	public static String getDesc() {
		return desc;
	}
	public static void setDesc(String desc) {
		ReimObj.desc = desc;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public static String getResolver() {
		return Resolver;
	}
	public static void setResolver(String resolver) {
		Resolver = resolver;
	}
	public int getRs_id() {
		return rs_id;
	}
	public void setRs_id(int rs_id) {
		this.rs_id = rs_id;
	}
	public static int getRt_id() {
		return rt_id;
	}
	public static void setRt_id(int rt_id) {
		ReimObj.rt_id = rt_id;
	}
	public ReimObj(Timestamp submit, Timestamp resolve, String author, int rs_id) {
		super();
		this.submit = submit;
		this.resolve = resolve;
		Author = author;
		this.rs_id = rs_id;
	}
	
}
