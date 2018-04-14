/**
 * 
 */
package com.gcl.dao;

import java.util.ArrayList;
import java.util.List;

import com.chen.jdbc.util.DbUtil;
import com.gcl.entity.City;
import com.gcl.entity.SjMakePaper;
import com.mysql.jdbc.StringUtils;
//import com.gcl.util.DbUtil;


/**
 * @Title: Controller
 * @Description: TODO
 * @author 郭传梁
 * @date 2017年11月4日
 * @version V1.0
 * 
 */

public class SjMakePaperDAO {
	public List<SjMakePaper> list(int a, int b) {
		List<SjMakePaper> citylist = new ArrayList<SjMakePaper>();
		String sql = "select * from sj_make_paper limit ?,?";
		citylist = DbUtil.select(sql,SjMakePaper.class,a,b);
		return citylist;
	}
	public List<SjMakePaper> list() {
		List<SjMakePaper> citylist = new ArrayList<SjMakePaper>();
		String sql = "select * from sj_make_paper";
		citylist = DbUtil.select(sql,SjMakePaper.class);
		return citylist;
	}
	public List<SjMakePaper> list(SjMakePaper entity) {
		List<SjMakePaper> citylist = new ArrayList<SjMakePaper>();
		String sql = "select * from sj_make_paper s where s.DATASTATE='1'";
		List<String> args=new ArrayList<String>();
		if(entity.getStudent_id()!=null){
			sql=sql+" and s.STUDENT_ID=?";
			args.add(entity.getStudent_id());
		}
		if(entity.getQp_id()!=null){
			sql=sql+" and s.QP_ID=?";
			args.add(entity.getQp_id());
		}
		citylist = DbUtil.select(sql,SjMakePaper.class,args.toArray());
		return citylist;
	}
	public SjMakePaper findOne(String id) {
		List<SjMakePaper> citylist = new ArrayList<SjMakePaper>();
		String sql = "select * from sj_make_paper s where s.ID= ? and s.DATASTATE='1'";
		citylist = DbUtil.select(sql,SjMakePaper.class,id);
		SjMakePaper s=new SjMakePaper();
		if(citylist!=null&&citylist.size()>0)
			s=citylist.get(0);
		return s;
	}
	public void delete(String id){
		
	};
	public SjMakePaper save(SjMakePaper entity){
		
		return entity;
	};
}
