package com.greenlabs.layoutdemo.core.service;

import com.greenlabs.layoutdemo.core.AppCore;
import com.greenlabs.layoutdemo.core.common.Constant;
import com.greenlabs.layoutdemo.core.dao.UserDAO;
import com.greenlabs.layoutdemo.core.entity.User;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Ivan on 10/6/17
 */
public class UserService extends BaseService {

    @Autowired
    private UserDAO userDAO;

    @Transactional
    private User doLogin(User user) {
        try {
            User currentUser = userDAO.getUsername(user.getUsername());
            if (currentUser != null) {
                StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
                if (passwordEncryptor.checkPassword(user.getPassword(), currentUser.getPassword())) {
                    AppCore.getInstance().getHttpSession().setAttribute(Constant.SESSION_USER, currentUser);
                    return user;
                }
            }


        } catch (DataAccessException dae) {
            AppCore.getLogger(this).error(dae.getMessage());
        }
        return null;
    }

}
