package com.skytiger.net.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skytiger.net.entity.StUser;
import com.skytiger.net.service.SysService;

@RestController
@RequestMapping("/admin")
public class AdminUser {
	@Resource
	private SysService sysService;

	@RequestMapping("/begin")
	public synchronized Map<String, Object> join(HttpServletRequest request) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		String userId = request.getParameter("userId") + "";
		StUser user = sysService.getUserById(userId);

		if(StringUtils.isEmpty(user.getUserStatus())) {
			user.setUserStatus("p");
			user.setRemark(request.getSession().getAttribute("adminUser") + "");
			sysService.updateByPrimaryKey(user);
			result.put("success", Boolean.TRUE);
		}else {
			result.put("success", Boolean.FALSE);
		}

		return result;
	}

	@RequestMapping("/end")
	public Map<String, Object> endSuccess(HttpServletRequest request) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		String userId = request.getParameter("userId") + "";
		StUser user = sysService.getUserById(userId);

		user.setRemark(request.getSession().getAttribute("adminUser") + "");
		user.setUpdateTime(new Date());
		user.setUserStatus("s");

		sysService.updateByPrimaryKey(user);
		result.put("success", Boolean.TRUE);

		return result;
	}

	@RequestMapping("/login")
	public Map<String, Object> login(HttpServletRequest request) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		String password = request.getParameter("password") + "";
		String userName = request.getParameter("userName") + "";

		com.skytiger.net.entity.AdminUser user = sysService.getAdminUser(userName, password);
		if (user != null) {
			request.getSession().setAttribute("adminUser", user.getAdId());
			result.put("success", Boolean.TRUE);
		} else {
			result.put("success", Boolean.FALSE);
		}

		return result; 
	}
	
	@RequestMapping("/getHasSuccess")
	public Map<String, Object> getHasSuccess(HttpServletRequest request) throws Exception {
		Map<String, Object> result = null;
		int page =Integer.parseInt(request.getParameter("page") + "") ;
		int record =Integer.parseInt(request.getParameter("record") + "");

		result = sysService.getUserOwer(request.getSession().getAttribute("adminUser") + "",page,record);
		
		if (result.size()>0) {
			result.put("success", Boolean.TRUE);
		} else {
			result.put("success", Boolean.FALSE);
		}

		return result;
	}
	
	@RequestMapping("/getNotPay")
	public Map<String, Object> getNotPay(HttpServletRequest request) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();

		List<StUser> userList = sysService.getNotPay(request.getSession().getAttribute("adminUser") + "");
		
		if (userList != null) {
			result.put("list", userList);
			result.put("success", Boolean.TRUE);
		} else {
			result.put("success", Boolean.FALSE);
		}

		return result;
	}
	
	@RequestMapping("/getTodayData")
	public Map<String, Object> getTodayData(HttpServletRequest request) throws Exception {
		Map<String, Object> result = null;

		result = sysService.getUserTodayData(request.getSession().getAttribute("adminUser") + "");
		
		if (result.size()>0) {
			result.put("success", Boolean.TRUE);
		} else {
			result.put("success", Boolean.FALSE);
		}

		return result;
	}

}
