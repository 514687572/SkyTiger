package com.skytiger.net.dao;

import java.util.List;

import com.skytiger.net.entity.StUser;
import com.skytiger.net.entity.SysTask;
import com.skytiger.net.entity.SysTaskExample;
import com.stip.mybatis.generator.plugin.GenericMapper;

 /**
 * generator XML
 **/
public interface SysTaskDao extends GenericMapper<SysTask, SysTaskExample, String> {

	void deleteByPrimaryKey(SysTask taskId);

	void deleteByExample(List<StUser> utask);
}