package com.greenlabs.layoutdemo.core.dao.impl;

import com.greenlabs.layoutdemo.core.dao.UserDAO;
import com.greenlabs.layoutdemo.core.entity.User;
import com.greenlabs.layoutdemo.core.entity.UserRole;
import com.greenlabs.layoutdemo.core.util.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Ivan on 10/6/17
 */
@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User save(User entity) {
        return null;
    }

    @Override
    public User update(User entity) {
        return null;
    }

    @Override
    public User delete(User entity) {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public List<User> find(User entity, Integer offset, Integer limit) {
        return null;
    }

    @Override
    public int count(User param) {
        return 0;
    }

    @Override
    public User getUsername(String username) {
        String sql = "SELECT * FROM " + Table.MASTER_USER + " u INNER JOIN "
                + Table.MASTER_ROLE + " r ON r.id=u.role_id "
                + "WHERE u.username = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{username}, new UserRowMapper());
    }

    @Override
    public String getPassword(User user) {
        String sql = "SELECT password FROM " + Table.MASTER_USER + " u "
                + "WHERE u.id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{user.getId()}, String.class);
    }

    class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setId(resultSet.getLong("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            UserRole userRole = new UserRole();
            userRole.setId(resultSet.getLong("role_id"));
            userRole.setName(resultSet.getString("name"));
            user.setUserRole(userRole);
            return user;
        }
    }

}
