package com.internousdev.tabicale.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CommonUtility {

	//ランダムな数字を作成します
	public String getRandomValue(){
		String value="";
		double d;
		for(int i=1;i<=16;i++){
			d = Math.random() * 10;
			value=value+((int)d);
		}
		return value;
	}

	//配列をカンマ区切りで分割します
	public String[] parseArrayList(String s){
		return s.split(", ",0);
	}

	//画像名を作り直します
	public String createFileName(String fileName){
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
		simpleDateFormat.applyPattern("yyymmddhhmmss");
		fileName = "calender"+simpleDateFormat.format(cal.getTime())+"."+fileName.substring(fileName.indexOf(".")+1);
		return fileName;
	}
}
