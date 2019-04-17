package com.liu.entity;

import java.util.Date;

public class UserLog {
		private Integer id;      //日志编号
	    private Date time;    //时间
	    private String type;    //类型
	    private String detail;  //详情
	    private String ip;      //ip地址

		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Date getTime() {
			return time;
		}
		public void setTime(Date time) {
			this.time = time;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getDetail() {
			return detail;
		}
		public void setDetail(String detail) {
			this.detail = detail;
		}
		public String getIp() {
			return ip;
		}
		public void setIp(String ip) {
			this.ip = ip;
		}
	    
}
