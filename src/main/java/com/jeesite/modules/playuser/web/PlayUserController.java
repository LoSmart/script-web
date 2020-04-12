/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.playuser.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.playuser.entity.PlayUser;
import com.jeesite.modules.playuser.service.PlayUserService;

/**
 * playUserController
 * @author gongxp
 * @version 2020-04-12
 */
@Controller
@RequestMapping(value = "${adminPath}/playuser/playUser")
public class PlayUserController extends BaseController {

	@Autowired
	private PlayUserService playUserService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public PlayUser get(String id, boolean isNewRecord) {
		return playUserService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("playuser:playUser:view")
	@RequestMapping(value = {"list", ""})
	public String list(PlayUser playUser, Model model) {
		model.addAttribute("playUser", playUser);
		return "modules/playuser/playUserList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("playuser:playUser:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<PlayUser> listData(PlayUser playUser, HttpServletRequest request, HttpServletResponse response) {
		playUser.setPage(new Page<>(request, response));
		Page<PlayUser> page = playUserService.findPage(playUser);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("playuser:playUser:view")
	@RequestMapping(value = "form")
	public String form(PlayUser playUser, Model model) {
		model.addAttribute("playUser", playUser);
		return "modules/playuser/playUserForm";
	}

	/**
	 * 保存play_user
	 */
	@RequiresPermissions("playuser:playUser:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated PlayUser playUser) {
		playUserService.save(playUser);
		return renderResult(Global.TRUE, text("保存play_user成功！"));
	}
	
	/**
	 * 删除play_user
	 */
	@RequiresPermissions("playuser:playUser:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(PlayUser playUser) {
		playUserService.delete(playUser);
		return renderResult(Global.TRUE, text("删除play_user成功！"));
	}
	
}