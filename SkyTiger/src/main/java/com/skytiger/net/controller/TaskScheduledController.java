package com.skytiger.net.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.skytiger.net.entity.StUser;
import com.skytiger.net.entity.SysTask;
import com.skytiger.net.service.ConfirmService;
import com.skytiger.net.service.OrderService;
import com.skytiger.net.service.RegisterService;
import com.skytiger.net.service.SysService;

/**
 * 系统任务
 * 
 * @author cja
 *
 */
@Component
@Lazy(false)
public class TaskScheduledController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	private SysService sysService;
	@Resource
	private RegisterService registerService;
	@Resource
	private OrderService orderService;
	@Resource
	private ConfirmService confirmService;
	
	public static boolean isRunning=false;
	
	/**
	 * 每5分钟检查一次需执行的任务
	 * 发货收货
	 * @return
	 * @throws Exception
	 * 47.96.75.60
	 */
	//@Scheduled(cron = "0/22 * * * * ?")
	public void updateNextRemindTime() throws Exception {
		List<SysTask> orderList = sysService.getTaskByStatus("3","orderConfirmHost");
		if(orderList!=null&&orderList.size()>0) {
			String taskId=orderList.get(0).getTaskId();
			SysTask task=sysService.getTaskById(taskId);
			int userCount = sysService.getUserCreateOrderOrS(taskId);

			if (userCount==task.getTaskCount()) {
				task.setTaskStatus("4");
				sysService.updateTaskStatus(task);
			}else if(!isRunning) {
				isRunning=true;
				orderService.placeAnOrder(task.getTaskUrl(),task.getTaskRemark(),task.getTaskId());
			}
			logger.info("正在创建订单");
			return;
		}else {
			List<SysTask> registerList = sysService.getTaskByStatus("1","orderConfirmHost");
			if(registerList!=null&&registerList.size()>0) {
				logger.info("正在注册用户");
				return;
			}
		}
		
			List<StUser> userList=sysService.getUserListHasInfoForUpdate("orderConfirmHost");
			
			if(userList!=null&&userList.size()>0) {
				confirmService.orderConfirm(userList);
				SysTask task=sysService.getTaskById(userList.get(0).getTaskId());
				task.setHostName("orderConfirmHost");
				
				sysService.updateTaskStatus(task);
			}else {
				List<SysTask> doregister = sysService.getTaskByStatus("1","orderConfirmHost");
				if (doregister != null && doregister.size() > 0) {
					logger.info("正在注册用户");
				} else {
					List<SysTask> register = sysService.getTaskByStatus("0");
					if (register != null && register.size() > 0) {
						SysTask taskRegister = register.get(0);
						registerService.doRegister(taskRegister);
						taskRegister.setTaskStatus("1");
						taskRegister.setHostName("orderConfirmHost");
						sysService.updateTaskStatus(taskRegister);
					}else {
						List<SysTask> taskList=sysService.getTaskByStatus("3","orderConfirmHost");
						if(taskList!=null&&taskList.size()>0) {
							String taskId=taskList.get(0).getTaskId();
							SysTask task=sysService.getTaskById(taskId);
							int userCount = sysService.getUserCreateOrder(taskId);
							
							if (userCount==task.getTaskCount()) {
								task.setTaskStatus("4");
								sysService.updateTaskStatus(task);
							}
							logger.info("正在创建订单");
						}else {
							List<SysTask> taskListToOrder = sysService.getTaskByStatus("2");
							if(taskListToOrder!=null&&taskListToOrder.size()>0) {
								SysTask task = taskListToOrder.get(0);
								task.setTaskStatus("3");
								task.setHostName("orderConfirmHost");
								sysService.updateTaskStatus(task);
								isRunning=true;
								orderService.placeAnOrder(task.getTaskUrl(),task.getTaskRemark(),task.getTaskId());
							}
						}
					}
				}
			}
		
	}
	
	/**
	 * 每5分钟检查一次需执行的任务
	 * 用户注册
	 * @return
	 * @throws Exception
	 * 116.62.134.104
	 */
	//@Scheduled(cron = "0/20 * * * * ?")
	public void updateNextRemindTimeTwo() throws Exception {
		List<SysTask> orderList = sysService.getTaskByStatus("3","registerHost");
		if(orderList!=null&&orderList.size()>0) {
			SysTask task=orderList.get(0);
			int userCount = sysService.getUserCreateOrderOrS(task.getTaskId());

			logger.info("正在创建订单，已创建"+userCount+"共需创建"+task.getTaskCount());
			if (userCount==task.getTaskCount()) {
				task.setTaskStatus("4");
				sysService.updateTaskStatus(task);
			}else if(!isRunning) {
				isRunning=true;
				orderService.placeAnOrder(task.getTaskUrl(),task.getTaskRemark(),task.getTaskId());
			}
			logger.info("正在创建订单");
			return;
		}
		
		List<SysTask> cList = sysService.getTaskByStatus("5","registerHost");
		if(cList!=null&&cList.size()>0) {
			logger.info("正在确认收货");
			return;
		}
		
		List<SysTask> doregister = sysService.getTaskByStatus("1","registerHost");
		if (doregister != null && doregister.size() > 0) {
			logger.info("正在注册用户");
		} else {
			List<SysTask> register = sysService.getTaskByStatus("0");
			if (register != null && register.size() > 0) {
				SysTask taskRegister = register.get(0);
				registerService.doRegister(taskRegister);
				taskRegister.setTaskStatus("1");
				taskRegister.setHostName("registerHost");
				sysService.updateTaskStatus(taskRegister);
			}else {
				List<SysTask> taskList=sysService.getTaskByStatus("3","registerHost");
				if(taskList!=null&&taskList.size()>0) {
					String taskId=taskList.get(0).getTaskId();
					SysTask task=sysService.getTaskById(taskId);
					int userCount = sysService.getUserCreateOrder(taskId);

					if (userCount==task.getTaskCount()) {
						task.setTaskStatus("4");
						sysService.updateTaskStatus(task);
					}else if(!isRunning) {
						isRunning=true;
						orderService.placeAnOrder(task.getTaskUrl(),task.getTaskRemark(),task.getTaskId());
					}
					logger.info("正在创建订单");
				}else {
					List<SysTask> taskListToOrder = sysService.getTaskByStatus("2");
					if(taskListToOrder!=null&&taskListToOrder.size()>0) {
						SysTask task = taskListToOrder.get(0);
						task.setTaskStatus("3");
						task.setHostName("registerHost");
						sysService.updateTaskStatus(task);
						isRunning=true;
						orderService.placeAnOrder(task.getTaskUrl(),task.getTaskRemark(),task.getTaskId());
					}else {
						List<StUser> userList=sysService.getUserListHasInfoForUpdate("registerHost");
						
						if(userList!=null&&userList.size()>0) {
							confirmService.orderConfirm(userList);
							SysTask task=sysService.getTaskById(userList.get(1).getTaskId());
							task.setHostName("registerHost");
							
							sysService.updateTaskStatus(task);
						}
					}
				}
			}
		}
	}
	
	/**
	 * 每5分钟检查一次需执行的任务
	 * 订单创建
	 * @return
	 * @throws Exception
	 * 47.96.67.161
	 */
	@Scheduled(cron = "0/21 * * * * ?")
	public void updateNextRemindTimeOne() throws Exception {
		List<SysTask> orderList = sysService.getTaskByStatus("1","orderCreateHost");
		if(orderList!=null&&orderList.size()>0) {
			logger.info("正在注册用户");
			return;
		}
		
		List<SysTask> cList = sysService.getTaskByStatus("5","orderCreateHost");
		if(cList!=null&&cList.size()>0) {
			logger.info("正在确认收货");
			return;
		}
		
		List<SysTask> taskList=sysService.getTaskByStatus("3","orderCreateHost");
		if(taskList!=null&&taskList.size()>0) {
			SysTask task=taskList.get(0);
			int userCount = sysService.getUserCreateOrderOrS(task.getTaskId());

			logger.info("正在创建订单，已创建"+userCount+"共需创建"+task.getTaskCount());
			if (userCount==task.getTaskCount()) {
				task.setTaskStatus("4");
				sysService.updateTaskStatus(task);
			}else if(!isRunning) {
				isRunning=true;
				orderService.placeAnOrder(task.getTaskUrl(),task.getTaskRemark(),task.getTaskId());
			}
			logger.info("正在创建订单");
		}else {
			List<SysTask> taskListToOrder = sysService.getTaskByStatus("2");
			if(taskListToOrder!=null&&taskListToOrder.size()>0) {
				SysTask task = taskListToOrder.get(0);
				task.setTaskStatus("3");
				task.setHostName("orderCreateHost");
				sysService.updateTaskStatus(task);
				isRunning=true;
				orderService.placeAnOrder(task.getTaskUrl(),task.getTaskRemark(),task.getTaskId());
			}else {
				List<SysTask> doregister = sysService.getTaskByStatus("1","orderCreateHost");
				if (doregister != null && doregister.size() > 0) {
					logger.info("正在注册用户");
				} else {
					List<SysTask> register = sysService.getTaskByStatus("0");
					if (register != null && register.size() > 0) {
						SysTask taskRegister = register.get(0);
						registerService.doRegister(taskRegister);
						taskRegister.setTaskStatus("1");
						taskRegister.setHostName("orderCreateHost");
						sysService.updateTaskStatus(taskRegister);
					}else {
						List<StUser> userList=sysService.getUserListHasInfoForUpdate("orderCreateHost");
						
						if(userList!=null&&userList.size()>0) {
							confirmService.orderConfirm(userList);
							SysTask task=sysService.getTaskById(userList.get(1).getTaskId());
							task.setHostName("orderCreateHost");
							
							sysService.updateTaskStatus(task);
						}
					}
				}
			}
		}
	}
	
}
