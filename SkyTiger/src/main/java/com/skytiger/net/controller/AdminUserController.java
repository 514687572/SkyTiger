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

import com.skytiger.net.entity.AdminUser;
import com.skytiger.net.entity.StUser;
import com.skytiger.net.entity.SysTask;
import com.skytiger.net.service.SysService;

@RestController
@RequestMapping("/admin")
public class AdminUserController {
	@Resource
	private SysService sysService;

	/**
	 * 开始支付
	 * @param request
	 * @return
	 * @throws Exception
	 */
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

	/**
	 * 支付完成
	 * @param request
	 * @return
	 * @throws Exception
	 */
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
	/**
	 * 修改订单号
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/exchange")
	public Map<String, Object> exchangeOrderId(HttpServletRequest request) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		String orderId = request.getParameter("OrderId")+"";
		String userId = request.getParameter("userId") + "";
		StUser user = sysService.getUserById(userId);
		user.setOrderNum(orderId);
		sysService.updateByPrimaryKey(user);
		result.put("success", Boolean.TRUE);
		return result;
	}
	

	/**
	 * 管理员登录
	 * @param request
	 * @return
	 * @throws Exception
	 */
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
	
	/**
	 * 查询已经支付完成的订单
	 * @param request
	 * @return
	 * @throws Exception
	 */
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
	
	/**
	 * 查询还未支付的订单
	 * @param request
	 * @return
	 * @throws Exception
	 */
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
	
	/**
	 * 查询当前管理员今日支付情况
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getTodayData")
	public Map<String, Object> getTodayData(HttpServletRequest request) throws Exception {
		Map<String, Object> result = null;

		result = sysService.getUserTodayData(request.getSession().getAttribute("adminUser") + "");
		
		if (result.size()>0) {
			result.put("success", Boolean.TRUE);
		} else {
			result.put("totalMoney", 0);
			result.put("success", Boolean.FALSE);
		}

		return result;
	}
	
	/**
	 * 查询所有管理员信息
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getAdminList")
	public Map<String, Object> getAdminList(HttpServletRequest request) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		List<AdminUser> adminList = sysService.getAllAdminUser();

		if (adminList!=null&&adminList.size()>0) {
			Map<String, Object> list = new HashMap<String, Object>();
			for(AdminUser user:adminList ) {
				list.put(user.getAdId(), user.getUsername());
			}
			
			result.put("adminList",list);
			result.put("success", Boolean.TRUE);
		}else {
			result.put("adminList",null);
			result.put("success", Boolean.FALSE);
		}
		

		return result;
	}
	/**
	 * 查询所有订单信息
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getTaskList")
	public Map<String, Object> getTaskList(HttpServletRequest request) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		List<SysTask> taskList = sysService.getTask();
		if(taskList != null && taskList.size() > 0) {
			for(SysTask task:taskList) {
				if(task.getTaskStatus().equals("0")) {
					task.setTaskStatus("未开始注册");
				}else if(task.getTaskStatus().equals("1")) {
					task.setTaskStatus("开始注册");
				}else if(task.getTaskStatus().equals("2")) {
					task.setTaskStatus("注册完成");
				}else if(task.getTaskStatus().equals("3")) {
					task.setTaskStatus("开始创建订单");
				}else if(task.getTaskStatus().equals("4")) {
					task.setTaskStatus("创建订单完成");
				}
			}
			result.put("taskList", taskList);
			result.put("success", Boolean.TRUE);
		}else {
			result.put("taskList", null);
			result.put("success", Boolean.FALSE);
		}
		
		return result;
	}
	
	}
