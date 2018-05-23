package com.skytiger.net.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skytiger.net.entity.StUser;
import com.skytiger.net.entity.SysTask;
import com.skytiger.net.service.SysService;
import com.skytiger.net.utils.GrnerateUUID;

@RestController
@RequestMapping("addInfo")
public class OrderController {
	@Resource
	private SysService sysService;
	
	/**
	 * 查询所有已经创建订单未开始支付的
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getAllUsers")
	public Map<String, Object> getAllUsers(HttpServletRequest request) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		List<StUser> userList = sysService.getUserListNotSuccess();

		if(userList!=null&&userList.size()>0) {
			result.put("userList",userList);
			result.put("success", Boolean.TRUE);
		}else {
			result.put("success", Boolean.FALSE);
		}

		return result;
	}
	
	@RequestMapping("/getDatas")
	public Map<String, Object> getDatas(HttpServletRequest request) throws Exception {
		Map<String, Object> result = null;
		result = sysService.getSysDatas();

		if(result!=null&&result.size()>0) {
			result.put("success", Boolean.TRUE);
		}else {
			result.put("success", Boolean.FALSE);
		}

		return result;
	}
	
	/**
	 * 添加系统任务
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addTask")
	public Map<String, Object> addTask(HttpServletRequest request) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		String count = request.getParameter("count");
		String goods_url = request.getParameter("goods_url");
		String admin_id = request.getParameter("adminId");
		String businessId = request.getParameter("businessId");
		
		SysTask task=new SysTask();
		task.setTaskId(GrnerateUUID.getUUID());
		task.setTaskCount(Integer.parseInt(count));
		task.setTaskUrl(goods_url);
		task.setTaskStatus("0");
		task.setTaskTime(new Date());
		task.setTaskRemark(admin_id);
		task.setTaskBusinessName(businessId);
		
		sysService.addTask(task);
		result.put("success", Boolean.TRUE);
		
		return result;
	}

}
