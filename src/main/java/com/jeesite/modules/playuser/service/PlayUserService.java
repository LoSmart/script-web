/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.playuser.service;


import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.file.utils.FileUploadUtils;
import com.jeesite.modules.playuser.dao.PlayUserDao;
import com.jeesite.modules.playuser.entity.PlayUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * playUserService
 * @author gongxp
 * @version 2020-04-12
 */
@Service
@Transactional(readOnly=true)
public class PlayUserService extends CrudService<PlayUserDao, PlayUser> {
	
	/**
	 * 获取单条数据
	 * @param playUser
	 * @return
	 */
	@Override
	public PlayUser get(PlayUser playUser) {
		return super.get(playUser);
	}
	
	/**
	 * 查询分页数据
	 * @param playUser 查询条件
	 * @param playUser.page 分页对象
	 * @return
	 */
	@Override
	public Page<PlayUser> findPage(PlayUser playUser) {
		return super.findPage(playUser);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param playUser
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(PlayUser playUser) {
		super.save(playUser);
		// 保存上传图片
		FileUploadUtils.saveFileUpload(playUser.getId(), "playUser_image");
		// 保存上传附件
		FileUploadUtils.saveFileUpload(playUser.getId(), "playUser_file");
	}
	
	/**
	 * 更新状态
	 * @param playUser
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(PlayUser playUser) {
		super.updateStatus(playUser);
	}
	
	/**
	 * 删除数据
	 * @param playUser
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(PlayUser playUser) {
		super.delete(playUser);
	}
	
}