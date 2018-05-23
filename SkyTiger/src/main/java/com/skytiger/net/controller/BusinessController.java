package com.skytiger.net.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skytiger.net.entity.SysBusiness;
import com.skytiger.net.service.SysService;

@RestController
@RequestMapping("business")
public class BusinessController {
	@Resource
	private SysService sysService;
	

	/**
	 * 查询所有商家信息
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getBusinessList")
	public Map<String, Object> getBusinessList(HttpServletRequest request) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		List<SysBusiness> adminList = sysService.getAllBusiness();

		if (adminList!=null&&adminList.size()>0) {
			Map<String, Object> list = new HashMap<String, Object>();
			for(SysBusiness busi:adminList ) {
				list.put(busi.getSbId(), busi.getSbTitle());
			}
			
			result.put("businesses",list);
			result.put("success", Boolean.TRUE);
		}else {
			result.put("businesses",null);
			result.put("success", Boolean.FALSE);
		}
		

		return result;
	}
}
