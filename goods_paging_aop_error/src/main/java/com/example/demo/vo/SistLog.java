package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //전체 생성자
@NoArgsConstructor	//기본 생성자
public class SistLog {
	private int no;
	private String uri;
	private String ip;
	private String time;
	private long stay;
	 
}
