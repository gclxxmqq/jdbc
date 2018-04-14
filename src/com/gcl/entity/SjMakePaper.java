/**
 * 
 */
package com.gcl.entity;

import java.math.BigDecimal;

public class SjMakePaper {
	private String id;
	private String qp_id;// 试卷ID
	private String student_id;// 学生ID
	private String school_id;// 学校ID
	private String a0141;// 年级
	private String a0142;// 科目
	private String class_id;// 班级ID
	private String class_name;// 班级
	private String qp_img;// 试卷图片
	private BigDecimal jm_score;// 卷面分
	private BigDecimal score;// 得分;
	private String optuser;
	private String optdate;
	private String optorg;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getQp_id() {
		return qp_id;
	}
	public void setQp_id(String qp_id) {
		this.qp_id = qp_id;
	}
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public String getSchool_id() {
		return school_id;
	}
	public void setSchool_id(String school_id) {
		this.school_id = school_id;
	}
	public String getA0141() {
		return a0141;
	}
	public void setA0141(String a0141) {
		this.a0141 = a0141;
	}
	public String getA0142() {
		return a0142;
	}
	public void setA0142(String a0142) {
		this.a0142 = a0142;
	}
	public String getClass_id() {
		return class_id;
	}
	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public String getQp_img() {
		return qp_img;
	}
	public void setQp_img(String qp_img) {
		this.qp_img = qp_img;
	}
	public BigDecimal getJm_score() {
		return jm_score;
	}
	public void setJm_score(BigDecimal jm_score) {
		this.jm_score = jm_score;
	}
	public BigDecimal getScore() {
		return score;
	}
	public void setScore(BigDecimal score) {
		this.score = score;
	}
	public String getOptuser() {
		return optuser;
	}
	public void setOptuser(String optuser) {
		this.optuser = optuser;
	}
	public String getOptdate() {
		return optdate;
	}
	public void setOptdate(String optdate) {
		this.optdate = optdate;
	}
	public String getOptorg() {
		return optorg;
	}
	public void setOptorg(String optorg) {
		this.optorg = optorg;
	}
	public String getDatastate() {
		return datastate;
	}
	public void setDatastate(String datastate) {
		this.datastate = datastate;
	}
	private String datastate;

	// `ID` varchar(32) NOT NULL DEFAULT '' COMMENT 'ID',
	// `QP_ID` varchar(32) DEFAULT NULL COMMENT '试卷ID',
	// `STUDENT_ID` varchar(32) DEFAULT NULL COMMENT '学生ID',
	// `SCHOOL_ID` varchar(32) DEFAULT NULL COMMENT '学校ID',
	// `A0141` varchar(3) DEFAULT NULL COMMENT '年级',
	// `A0142` varchar(3) DEFAULT NULL COMMENT '科目',
	// `CLASS_NAME` varchar(32) DEFAULT NULL COMMENT '班级',
	// `SCORE` decimal(10,1) DEFAULT NULL COMMENT '得分',
	// `QP_IMG` varchar(1000) DEFAULT NULL COMMENT '试卷图片',
	// `JM_SCORE` decimal(10,1) DEFAULT NULL COMMENT '卷面分',
	// `DATASTATE` varchar(3) DEFAULT NULL COMMENT '数据状态',
	// `OPTUSER` varchar(32) DEFAULT NULL COMMENT '经办人',
	// `OPTORG` varchar(32) DEFAULT NULL COMMENT '经办机构',
	// `OPTDATE` varchar(20) DEFAULT NULL COMMENT '经办时间',
	// `CLASS_ID` varchar(32) DEFAULT NULL COMMENT '班级ID',
}
