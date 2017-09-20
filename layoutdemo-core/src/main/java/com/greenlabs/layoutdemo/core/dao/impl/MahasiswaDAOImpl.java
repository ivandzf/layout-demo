package com.greenlabs.layoutdemo.core.dao.impl;

import com.greenlabs.layoutdemo.core.dao.MahasiswaDAO;
import com.greenlabs.layoutdemo.core.entity.Mahasiswa;
import com.greenlabs.layoutdemo.core.util.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan-TI on 9/20/2017
 **/
@Repository
public class MahasiswaDAOImpl implements MahasiswaDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Mahasiswa save(Mahasiswa entity) {
        String sql = "INSERT INTO " + Table.MASTER_MAHASISWA + " (" +
                "nim,"+
                "nama,"+
                "jurusan," +
                "created_time) "+
                "VALUES (?,?,?,?)";
        jdbcTemplate.update(sql,
                entity.getNIM(),
                entity.getNama(),
                entity.getJurusan(),
                new Timestamp(entity.getCreatedTime().getTime()));
        return entity;
    }

    @Override
    public Mahasiswa update(Mahasiswa entity) {
        String sql = "UPDATE " + Table.MASTER_MAHASISWA + " SET " +
                "nim = ?," +
                "nama = ?," +
                "jurusan = ? " +
                "WHERE id= ?";
        jdbcTemplate.update(sql,
                entity.getNIM(),
                entity.getNama(),
                entity.getJurusan(),
                entity.getId());
        return entity;
    }

    @Override
    public Mahasiswa delete(Mahasiswa entity) {
        String sql = "DELETE FROM " + Table.MASTER_MAHASISWA + " WHERE id=?";
        jdbcTemplate.update(sql,entity.getId());
        return entity;
    }

    @Override
    public Mahasiswa findById(Long id) {
        String sql = "SELECT * FROM " + Table.MASTER_MAHASISWA + " a WHERE a.id?";
        try {
            return jdbcTemplate.queryForObject(sql, new MahasiswaRowMapper(), id);
        } catch (EmptyResultDataAccessException e) {

        }
        return null;
    }

    @Override
    public List<Mahasiswa> find(Mahasiswa entity, Integer offset, Integer limit) {
        String sql = "SELECT * FROM " + Table.MASTER_MAHASISWA +
                " WHERE 1 = 1";
        List<Object> params = new ArrayList<>();
        if(entity.getNIM() != null){
            params.add("%" + entity.getNIM() + "%");
            sql += " AND nim LIKE ?";
        }
        return jdbcTemplate.query(sql,params.toArray(), new MahasiswaRowMapper());
    }

    class MahasiswaRowMapper implements RowMapper<Mahasiswa>{

        @Override
        public Mahasiswa mapRow(ResultSet resultSet, int i) throws SQLException {
            Mahasiswa mahasiswa = new Mahasiswa();
            mahasiswa.setId(resultSet.getLong("id"));
            mahasiswa.setNama(resultSet.getString("nama"));
            mahasiswa.setJurusan(resultSet.getString("jurusan"));
            mahasiswa.setCreatedTime(resultSet.getTimestamp("created_time"));
            return mahasiswa;
        }
    }

}
