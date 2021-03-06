package com.sibu.common.web.realm;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.session.Session;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import com.sibu.common.massage.ResponseUtil;
import com.sibu.common.util.HttpUtil;

/**
 * <p>User: dao
 * <p>Date: 14-3-16
 * <p>Version: 1.0
 */
public class ForceLogoutFilter extends AccessControlFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        Session session = getSubject(request, response).getSession(false);
        String pash = getLoginUrl();
        if(session == null) {
        	
            return false;
        }
        return session.getAttribute(Constants.SESSION_FORCE_LOGOUT_KEY) == null;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        try {
            getSubject(request, response).logout();//强制退出
        } catch (Exception e) {/*ignore exception*/}

//        String loginUrl = getLoginUrl() + (getLoginUrl().contains("?") ? "&" : "?") + "forceLogout=1";
//        String loginUrl = "/user/erron";
//        WebUtils.issueRedirect(request, response, loginUrl);
        HttpUtil.writeError(response,"非法链接!");
//        ResponseUtil.unknownVersion();
        return false;
    }
}
