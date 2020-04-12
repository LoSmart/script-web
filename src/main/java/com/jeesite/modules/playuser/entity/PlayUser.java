/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.playuser.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * playUserEntity
 * @author gongxp
 * @version 2020-04-12
 */
@Table(name="play_user", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="nickname", attrName="nickname", label="昵称"),
		@Column(name="img", attrName="img", label="头像"),
		@Column(name="city", attrName="city", label="城市"),
		@Column(name="code", attrName="code", label="用户登录凭证"),
		@Column(name="unionid", attrName="unionid", label="unionid"),
		@Column(name="openid", attrName="openid", label="openid"),
		@Column(name="authkey", attrName="authkey", label="加密随机字符串"),
		@Column(name="createtime", attrName="createtime", label="createtime"),
		@Column(name="updatetime", attrName="updatetime", label="updatetime"),
	}, orderBy="a.id DESC"
)
public class PlayUser extends DataEntity<PlayUser> {
	
	private static final long serialVersionUID = 1L;
	private String nickname;		// 昵称
	private String img;		// 头像
	private String city;		// 城市
	private String code;		// 用户登录凭证
	private String unionid;		// unionid
	private String openid;		// openid
	private String authkey;		// 加密随机字符串
	private Date createtime;		// createtime
	private Date updatetime;		// updatetime
	
	public PlayUser() {
		this(null);
	}

	public PlayUser(String id){
		super(id);
	}
	
	@Length(min=0, max=50, message="昵称长度不能超过 50 个字符")
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	@Length(min=0, max=255, message="头像长度不能超过 255 个字符")
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
	@Length(min=0, max=255, message="城市长度不能超过 255 个字符")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	@Length(min=0, max=10, message="用户登录凭证长度不能超过 10 个字符")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@Length(min=0, max=50, message="unionid长度不能超过 50 个字符")
	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	
	@Length(min=0, max=50, message="openid长度不能超过 50 个字符")
	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
	@Length(min=0, max=10, message="加密随机字符串长度不能超过 10 个字符")
	public String getAuthkey() {
		return authkey;
	}

	public void setAuthkey(String authkey) {
		this.authkey = authkey;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	
}