package com.sibu.api.user;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sibu.common.massage.ResponseUtil;
import com.sibu.common.util.Version;
import com.sibu.dao.user.bean.UserBean;
import com.sibu.service.user.UserService;


@Controller
@RequestMapping(value = "/test",produces="application/json")
public class TestAtion {
	
	/** 用户服务接口 */
	@Resource
	private UserService userService;
	
	/**
	 * 获取 对象
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value = "/listtest", method = RequestMethod.GET) 
	@ResponseBody
	public String getUserInfo(String param,String version,HttpServletRequest req, HttpServletResponse res) throws Exception{
		if(Version.V10.equals(version)){
			UserBean ub = userService.getBeanById(param);
			return ResponseUtil.data(ub);
		}
		return ResponseUtil.unknownVersion();
	}
}
