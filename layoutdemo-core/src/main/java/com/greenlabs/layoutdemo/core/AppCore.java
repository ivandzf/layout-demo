package com.greenlabs.layoutdemo.core;

import com.greenlabs.layoutdemo.core.common.Constant;
import com.greenlabs.layoutdemo.core.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.HttpCookie;

/**
 * Created by Ivan-TI on 9/20/2017
 **/
public class AppCore {

    private static class AppCoreHolder {
        private static final AppCore INSTANCE = new AppCore();
    }

    public static AppCore getInstance() {
        return AppCoreHolder.INSTANCE;
    }

    public static Logger getLogger(Object o) {
        return LoggerFactory.getLogger(o.getClass());
    }

    public HttpServletRequest getHttpServletRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attributes.getRequest();
    }

    public HttpSession getHttpSession() {
        return getHttpServletRequest().getSession();
    }

    public User getUserFromSession() {
        User user = (User) getHttpSession().getAttribute(Constant.SESSION_USER);
        if (user != null) {
            return user;
        }
        return null;
    }

}
