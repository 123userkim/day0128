package com.example.demo.dao;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.db.DBManager;
import com.example.demo.vo.ExceptionLog;

@Repository
public class ExceptionLogDAO {
	public int insert(ExceptionLog log) {
		return DBManager.insertEXceptionLog(log);
	}
}
