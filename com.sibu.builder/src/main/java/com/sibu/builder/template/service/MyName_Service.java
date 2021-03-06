package com.sibu.builder.template.service;

import java.util.List;
import java.util.Map;

import com.sibu.builder.template.bean.MyName_Bean;
import com.sibu.common.bean.StatusBean;
import com.sibu.common.mybatis.page.Pagination;

/**
 * MyName_Service
 * @author 作者_
**/
public interface MyName_Service {
	/**
	 * 根据ID获取类别信息
	 * @param id 数据ID
	 * @return MyName_Bean 数据bean对象
	 * @throws Exception
	 **/
	public MyName_Bean getBeanById(String id) throws Exception;
	/**
	 * 查询所有数据
	 * @return List<SysMenuExtendBean>
	 * @throws Exception
	 */
	public List<MyName_Bean> listAll() throws Exception;
	/**
	 * 查询记录总数
	 * @param params 查询条件
	 * @return int 查询的记录总数
	 * @throws Exception
	 **/
	public int count(MyName_Bean brean) throws Exception;
	/**
	 * 查询所有数据
	 * @param params 查询条件
	 * @return List<MyName_Bean> 查询后返回的结果集
	 * @throws Exception
	 **/
	public List<MyName_Bean> list(Map<String, Object> params) throws Exception;
	/**
	 * 分页查询
	 * @param  Id 需要获取的相关列表
	 * @param  page 当前页码
	 * @param  size 每页的显示多少
	 * @return Pagination 分页对象
	 * @throws Exception
	 */
	public Pagination<MyName_Bean> list(Map<String, Object> params,int page, int size) throws Exception;
	/**
	 * 保存
	 * @param bean 需要保存的bean对象
	 * @param user 当前操作人
	 * @return StatusBean 操作状态
	 * @throws Exception
	 **/
	public StatusBean<?> save(MyName_Bean bean) throws Exception;
	/**
	 * 更新
	 * @param bean 需要更新的bean对象
	 * @param user 当前操作人
	 * @return boolean 返回true表示更新成功；返回false表示更新失败； 
	 * @throws Exception
	 **/
	public StatusBean<?> update(MyName_Bean bean) throws Exception;
	/**
	 * 删除
	 * @param id 待删除的数据ID
	 * @return boolean 返回true表示删除成功；返回false表示删除失败；
	 * @throws Exception
	 **/
	public StatusBean<?> deleteById(String id)  throws Exception;
	/**
	 * 批量删除
	 * @param ids 待删除的数据ID数组
	 * @return boolean 返回true表示删除成功；返回false表示删除失败；
	 * @throws Exception
	 **/
	public StatusBean<?> batchDelete(String ids) throws Exception;
}