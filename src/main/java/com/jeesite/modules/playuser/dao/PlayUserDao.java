/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.playuser.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.playuser.entity.PlayUser;

/**
 * playUserDAO接口
 * @author gongxp
 * @version 2020-04-12
 */
@MyBatisDao
public interface PlayUserDao extends CrudDao<PlayUser> {
	
}