/**
 * 
 */
package com.gcl.test;

import java.util.List;

import com.gcl.dao.CityDao;
import com.gcl.dao.SjMakePaperDAO;
import com.gcl.entity.City;
import com.gcl.entity.SjMakePaper;

/**
 * @Title: Controller
 * @Description: TODO
 * @author 郭传梁
 * @date 2017年11月4日
 * @version V1.0
 *
 */

public class AddDate {
	public static void main(String[] args) {
		SjMakePaperDAO s=new SjMakePaperDAO();
		List<SjMakePaper> sl=s.list();
		System.out.println(sl.size());
		SjMakePaper p1=s.findOne("f5a2c9de5f6c9165015f6c977cb80368");
		System.out.println(p1.getClass_name());
		SjMakePaper s1=new SjMakePaper();
		s1.setStudent_id("402883ec5f32bc7c015f33641e800019");
		s1.setQp_id("f5a2c9de5f354ce9015f3792186b0007");
		List<SjMakePaper> sl1=s.list(s1);
		System.out.println(sl1.size());
		System.out.println(sl1.get(0).getClass_name());
	}
}
