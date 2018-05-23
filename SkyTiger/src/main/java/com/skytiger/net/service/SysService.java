package com.skytiger.net.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.skytiger.net.dao.AddressInfoDao;
import com.skytiger.net.dao.AdminUserDao;
import com.skytiger.net.dao.DictionaryDao;
import com.skytiger.net.dao.StUserDao;
import com.skytiger.net.dao.SysBusinessDao;
import com.skytiger.net.dao.SysPostDao;
import com.skytiger.net.dao.SysTaskDao;
import com.skytiger.net.entity.AddressInfo;
import com.skytiger.net.entity.AddressInfoExample;
import com.skytiger.net.entity.AdminUser;
import com.skytiger.net.entity.AdminUserExample;
import com.skytiger.net.entity.Dictionary;
import com.skytiger.net.entity.DictionaryExample;
import com.skytiger.net.entity.StUser;
import com.skytiger.net.entity.StUserExample;
import com.skytiger.net.entity.SysBusiness;
import com.skytiger.net.entity.SysBusinessExample;
import com.skytiger.net.entity.SysPost;
import com.skytiger.net.entity.SysPostExample;
import com.skytiger.net.entity.SysTask;
import com.skytiger.net.entity.SysTaskExample;
import com.skytiger.net.entity.base.BSysTask;

@Service
public class SysService {
	@Resource
	private StUserDao stUserDao;
	@Resource
	private AdminUserDao adminUserDao;
	@Resource
	private AddressInfoDao addressInfoDao;
	@Resource
	private SysTaskDao sysTaskDao;
	@Resource
	private DictionaryDao dictionaryDao;
	@Resource
	private SysPostDao sysPostDao;
	@Resource
	private SysBusinessDao sysusinessDao;
	
	public void addUser(StUser record) {
		stUserDao.insert(record);
	}
	
	public void addPostNum(SysPost record) {
		sysPostDao.insert(record);
	}
	
	public void addAddressInfo(AddressInfo record) {
		addressInfoDao.insert(record);
	}
	
	public List<StUser> getUserList(String adminid) {
		StUserExample example=new StUserExample();
		example.createCriteria().andRemarkEqualTo(adminid).andUserStatusIsNull();
		
		List<StUser> userList=stUserDao.selectByExample(example);
		
		return userList;
	}
	
	public List<StUser> getUserListToOrder() {
		StUserExample example=new StUserExample();
		example.createCriteria().andRemarkIsNotNull().andUserStatusIsNull();
		
		List<StUser> userList=stUserDao.selectByExample(example);
		
		return userList;
	}
	
	public int getUserCreateOrder(String taskId) {
		StUserExample example=new StUserExample();
		example.createCriteria().andRemarkIsNotNull().andUserStatusEqualTo("p").andTaskIdEqualTo(taskId);
		
		int count=stUserDao.countByExample(example);
		
		return count;
	}
	
	public int getUserCreateOrderOrS(String taskId) {
		StUserExample example=new StUserExample();
		example.createCriteria().andRemarkIsNotNull().andUserStatusEqualToORS("'p'","'s'","'e'").andTaskIdEqualTo(taskId);
		
		int count=stUserDao.countByExample(example);
		
		return count;
	}
	
	public int getUserCreateFinish(String taskId) {
		StUserExample example=new StUserExample();
		example.createCriteria().andRemarkIsNotNull().andUserStatusEqualTo("e").andTaskIdEqualTo(taskId);
		
		int count=stUserDao.countByExample(example);
		
		return count;
	}
	
	public List<SysPost> getPostNumList() {
		SysPostExample example=new SysPostExample();
		
		List<SysPost> userList=sysPostDao.selectByExample(example);
		
		return userList;
	}
	
	public void deletePostNum(SysPost record) {
		sysPostDao.deleteByPrimaryKey(record.getPostId()+"");
	}
	
	public SysBusiness getBusinessById(String id) {
		SysBusinessExample example=new SysBusinessExample();
		example.createCriteria().andSbIdEqualTo(id);
		
		List<SysBusiness> userList=sysusinessDao.selectByExample(example);
		
		if(userList!=null&&userList.size()>0) {
			return userList.get(0);
		}
		
		return null;
	}
	
	public List<AddressInfo> getAddressList() {
		AddressInfoExample example=new AddressInfoExample();
		List<AddressInfo> addressList=addressInfoDao.selectByExample(example);
		
		return addressList;
	}
	
	public List<SysTask> getTaskByStatus(String status) {
		SysTaskExample example=new SysTaskExample();
		example.createCriteria().andTaskStatusEqualTo(status);//0未开始1正在注册2注册完成3正在创建订单4执行完成
		
		List<SysTask> taskList=sysTaskDao.selectByExample(example);
		
		return taskList;
	}
	
	public List<SysTask> getTaskByStatus(String status,String host) {
		SysTaskExample example=new SysTaskExample();
		example.createCriteria().andTaskStatusEqualTo(status).andHostNameEqualTo(host);//0未开始1正在注册2注册完成3正在创建订单4执行完成
		
		List<SysTask> taskList=sysTaskDao.selectByExample(example);
		
		return taskList;
	}
	
	public SysTask getTaskById(String id) {
		SysTaskExample example=new SysTaskExample();
		example.createCriteria().andTaskIdEqualTo(id);
		
		List<SysTask> taskList=sysTaskDao.selectByExample(example);
		
		if(taskList!=null&&taskList.size()==1) {
			return taskList.get(0);
		}
		
		return null;
	}
	
	public List<SysTask> getOrStatus(String value,String value1) {
		SysTaskExample example=new SysTaskExample();
		example.createCriteria().orTaskStatusEqualTo(value, value1);
		
		List<SysTask> taskList=sysTaskDao.selectByExample(example);
		
		return taskList;
	}
	
	public void updateTaskStatus(SysTask record) {
		sysTaskDao.updateByPrimaryKey(record);
	}
	
	public void addTask(SysTask record) {
		sysTaskDao.insert(record);
	}
	
	/**
	 * 查询还未生成订单的的用户
	 * @return
	 */
	public List<StUser> getUserListNotSuccess() {
		StUserExample example=new StUserExample();
		example.createCriteria().andRemarkEqualTo("1");
		
		List<StUser> userList=stUserDao.selectByExample(example);
		
		return userList;
	}
	
	/**
	 * 查询系统已支付和未支付的订单情况
	 * @return
	 */
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
	
	/**
	 * 根据注册用户ID查询注册用户信息
	 * @param id
	 * @return
	 */
	public StUser getUserById(String id) {
		StUserExample example=new StUserExample();
		example.createCriteria().andUserIdEqualTo(id);
		
		List<StUser> userList=stUserDao.selectByExample(example);
		
		if(userList!=null&&userList.size()>0) {
			return userList.get(0);
		}
		return null;
	}
	
	/**
	 * 根据任务ID查询用户信息
	 * @param id
	 * @return
	 */
	public List<StUser> getUserByTaskId(String taskid) {
		StUserExample example=new StUserExample();
		example.createCriteria().andTaskIdEqualTo(taskid);
		
		List<StUser> userList=stUserDao.selectByExample(example);
		
		if(userList!=null&&userList.size()>0) {
			return userList;
		}
		return null;
	}
	
	/**
	 * 根据任务ID查询用户信息
	 * @param id
	 * @return
	 */
	public List<StUser> getUsersByTaskId(String taskid) {
		StUserExample example=new StUserExample();
		example.createCriteria().andTaskIdEqualTo(taskid).andUserStatusIsNull();;
		
		List<StUser> userList=stUserDao.selectByExample(example);
		
		if(userList!=null&&userList.size()>0) {
			return userList;
		}
		return null;
	}
	
	/**
	 * 查询用户已经领取多少单
	 * @param userId
	 * @param records
	 * @param page
	 * @return
	 */
	public Map<String, Object> getUserOwer(String userId,int records,int page) {
		Map<String, Object> result = new HashMap<String, Object>();
		StUserExample example=new StUserExample();
		example.createCriteria().andRemarkEqualTo(userId).andUserStatusEqualTo("e");
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
	
	/**
	 * 查询出管理员当天的支付情况
	 * @param userId
	 * @return
	 */
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
		example.createCriteria().andRemarkEqualTo(userId).andUpdateTimeGreaterThanOrEqualTo(date).andUpdateTimeLessThan(endDate).andUserStatusEqualTo("s");
		
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
				totalMoney+=Double.parseDouble(order.getOrderPrice());
			}
			
			result.put("totalMoney", totalMoney);
			return result;
		}
		
		return result;
	}
	
	/**
	 * 查询出当前管理员还未支付的订单
	 */
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
	
	/**
	 * 管理员用户登录
	 * @param name
	 * @param pwd
	 * @return
	 */
	public AdminUser getAdminUser(String name,String pwd) {
		AdminUserExample example=new AdminUserExample();
		example.createCriteria().andUsernameEqualTo(name).andPasswordEqualTo(pwd);
		
		List<AdminUser> userList=adminUserDao.selectByExample(example);
		
		if(userList!=null&&userList.size()>0) {
			return userList.get(0);
		}
		return null;
	}
	
	/**
	 * 查询所有管理员用户
	 * @param name
	 * @param pwd
	 * @return
	 */
	public List<AdminUser> getAllAdminUser() {
		AdminUserExample example=new AdminUserExample();
		List<AdminUser> userList=adminUserDao.selectByExample(example);
		
		if(userList!=null&&userList.size()>0) {
			return userList;
		}
		return null;
	}
	
	/**
	 * 查询所有商家信息
	 * @param name
	 * @param pwd
	 * @return
	 */
	public List<SysBusiness> getAllBusiness() {
		SysBusinessExample example=new SysBusinessExample();
		List<SysBusiness> userList=sysusinessDao.selectByExample(example);
		
		if(userList!=null&&userList.size()>0) {
			return userList;
		}
		return null;
	}
	
	/**
	 * 查询出所有已经创建好订单支付完成的用户信息
	 * @return
	 */
	public synchronized List<StUser> getUserListHasInfoForUpdate(String confirmHost) {
		StUserExample example=new StUserExample();
		example.createCriteria().andRemarkNotEqualTo("1").andUserStatusEqualTo("s").andConfirmHostIsNull();//1是已经创建好订单
		example.setPager(1, 5);
		List<StUser> userList=stUserDao.selectByExample(example);
		
		if(userList!=null&&userList.size()>0) {
			for(StUser user:userList) {
				user.setConfirmHost(confirmHost);
				stUserDao.updateByPrimaryKey(user);
			}
		}
		
		return userList;
	}
	
	/**
	 * 查询出所有已经创建好订单支付完成的用户信息
	 * @return
	 */
	public List<StUser> getUserListHasInfo(String host) {
		StUserExample example=new StUserExample();
		example.createCriteria().andRemarkNotEqualTo("1").andUserStatusEqualTo("s").andOrderNumEqualTo(host);//1是已经创建好订单
		example.setPager(1, 10);
		List<StUser> userList=stUserDao.selectByExample(example);
		
		return userList;
	}
	
	/**
	 * 查询出所有已经创建好订单支付完成的用户信息
	 * @return
	 */
	public List<StUser> getUserListHasInfo() {
		StUserExample example=new StUserExample();
		example.createCriteria().andRemarkNotEqualTo("1").andUserStatusEqualTo("s");//1是已经创建好订单
		List<StUser> userList=stUserDao.selectByExample(example);
		
		return userList;
	}
	
	public void updateByPrimaryKey(StUser record) {
		stUserDao.updateByPrimaryKey(record);
	}
	
	public List<Dictionary> getDictoryByType(String type) {
		DictionaryExample example=new DictionaryExample();
		example.createCriteria().andDicTypeEqualTo(type);
		
		List<Dictionary> dicList=dictionaryDao.selectByExample(example);
		
		if(dicList!=null&&dicList.size()>0) {
			return dicList;
		}
		return null;
	}
	/**
	 * 查询出所有订单信息
	 * @return
	 */
	public List<SysTask> getTask(){
		SysTaskExample example = new SysTaskExample();
		
		List<SysTask> list = sysTaskDao.selectByExample(example);
		
		return list;
	}
	
}
