package com.skytiger.net.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.skytiger.net.dao.AdminUserDao;
import com.skytiger.net.dao.StUserDao;
import com.skytiger.net.entity.AdminUser;
import com.skytiger.net.entity.AdminUserExample;
import com.skytiger.net.entity.StUser;
import com.skytiger.net.entity.StUserExample;
import com.skytiger.net.utils.TimeUtils;

@Service
public class SysService {
	@Resource
	private StUserDao stUserDao;
	@Resource
	private AdminUserDao adminUserDao;
	
	public void addUser(StUser record) {
		stUserDao.insert(record);
	}
	
	public List<StUser> getUserList() {
		StUserExample example=new StUserExample();
		example.createCriteria().andRemarkIsNull();
		
		List<StUser> userList=stUserDao.selectByExample(example);
		
		return userList;
	}
	
	public List<StUser> getUserListNotSuccess() {
		StUserExample example=new StUserExample();
		example.createCriteria().andUserStatusIsNull();
		
		List<StUser> userList=stUserDao.selectByExample(example);
		
		return userList;
	}
	
	public Map<String, Object> getSysDatas() {
		Map<String, Object> result = new HashMap<String, Object>();
		StUserExample example=new StUserExample();
		example.createCriteria().andUserStatusIsNull();
		
		int count=stUserDao.countByExample(example);
		result.put("count", count);
		
		StUserExample example1=new StUserExample();
		example1.createCriteria().andUserStatusIsNotNull();
		
		int PCount=stUserDao.countByExample(example1);
		result.put("PCount", PCount);
		
		return result;
	}
	
	public StUser getUserById(String id) {
		StUserExample example=new StUserExample();
		example.createCriteria().andUserIdEqualTo(id);
		
		List<StUser> userList=stUserDao.selectByExample(example);
		
		if(userList!=null&&userList.size()>0) {
			return userList.get(0);
		}
		return null;
	}
	
	public Map<String, Object> getUserOwer(String userId,int records,int page) {
		Map<String, Object> result = new HashMap<String, Object>();
		StUserExample example=new StUserExample();
		example.createCriteria().andRemarkEqualTo(userId);
		example.setOrderByClause(" stUser.update_time desc");
		
		example.setPager(page, records);
		
		List<StUser> userList=stUserDao.selectByExample(example);
		int count=stUserDao.countByExample(example);
		
		if(count>0) {
			int pages=(count/page)+((count%page)>0?1:0);
			result.put("pages", pages);
		}else {
			result.put("pages", 0);
		}
		
		if(userList!=null&&userList.size()>0) {
			result.put("list", userList);
			return result;
		}
		
		return result;
	}
	
	public Map<String, Object> getUserTodayData(String userId) {
		Map<String, Object> result = new HashMap<String, Object>();
		Date date=new Date();
		date.setHours(00);
		date.setMinutes(00);
		date.setSeconds(00);
		Date endDate=new Date();
		endDate.setHours(23);
		endDate.setMinutes(59);
		endDate.setSeconds(59);
		StUserExample example=new StUserExample();
		example.createCriteria().andRemarkEqualTo(userId).andUpdateTimeGreaterThanOrEqualTo(date).andUpdateTimeLessThan(endDate);
		
		List<StUser> userList=stUserDao.selectByExample(example);
		int count=stUserDao.countByExample(example);
		
		if(count>0) {
			result.put("orderNum", count);
		}else {
			result.put("orderNum", 0);
		}
		
		if(userList!=null&&userList.size()>0) {
			long totalMoney=0;
			for(StUser order:userList) {
				totalMoney+=Long.parseLong(order.getOrderPrice());
			}
			
			result.put("totalMoney", totalMoney);
			return result;
		}
		
		return result;
	}
	
	public List<StUser> getNotPay(String userId) {
		StUserExample example=new StUserExample();
		example.createCriteria().andRemarkEqualTo(userId).andUserStatusEqualTo("p");
		example.setOrderByClause(" stUser.update_time desc");
		
		List<StUser> userList=stUserDao.selectByExample(example);
		
		if(userList!=null&&userList.size()>0) {
			return userList;
		}
		return null;
	}
	
	public AdminUser getAdminUser(String name,String pwd) {
		AdminUserExample example=new AdminUserExample();
		example.createCriteria().andUsernameEqualTo(name).andPasswordEqualTo(pwd);
		
		List<AdminUser> userList=adminUserDao.selectByExample(example);
		
		if(userList!=null&&userList.size()>0) {
			return userList.get(0);
		}
		return null;
	}
	
	public List<StUser> getUserListHasInfo() {
		StUserExample example=new StUserExample();
		example.createCriteria().andRemarkNotEqualTo("1").andRemarkIsNotNull();
		
		List<StUser> userList=stUserDao.selectByExample(example);
		
		return userList;
	}
	
	public void updateByPrimaryKey(StUser record) {
		stUserDao.updateByPrimaryKey(record);
	}

}
