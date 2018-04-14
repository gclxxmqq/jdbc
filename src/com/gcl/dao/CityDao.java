package com.gcl.dao;

import java.util.ArrayList;
import java.util.List;


import com.chen.jdbc.util.DbUtil;
//import com.gcl.util.DbUtil;
import com.gcl.entity.City;

public class CityDao {
	public List<City> listAll(int a,int b){
		List<City> citylist=new ArrayList<City>();
		String sql="select * from sys_district limit ?,?";
		citylist=DbUtil.select(sql, City.class,a,b);
		return citylist;
	}
	public List<City> listAll(){
		List<City> citylist=new ArrayList<City>();
		String sql="select * from sys_district order by id";
		citylist=DbUtil.select(sql, City.class);
		return citylist;
	}
	public List<City> listSheng(){
		List<City> citylist=new ArrayList<City>();
		String sql="select * from sys_district where ID LIKE ? ";
		citylist=DbUtil.select(sql, City.class,"%0000");
		return citylist;
	}
	public List<City> listShi(String sheng){
		List<City> citylist=new ArrayList<City>();
		String qian2=sheng.substring(0, 2);
		String sql="select * from sys_district where id <> '"+sheng+"' and ID REGEXP ? ";
		String regex=qian2+"[0-9][0-9]00";
		citylist=DbUtil.select(sql, City.class,regex);
		return citylist;
	}
	public List<City> listXian(String sheng){
		List<City> citylist=new ArrayList<City>();
		String qian2=sheng.substring(0, 4);
		String sql="select * from sys_district where id <> '"+sheng+"' and ID REGEXP ? ";
		String regex=qian2+"[0-9][0-9]";
		citylist=DbUtil.select(sql, City.class,regex);
		return citylist;
	}
}
