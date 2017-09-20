package com.greenlabs.layoutdemo.core.service;

import com.greenlabs.layoutdemo.core.dao.MahasiswaDAO;
import com.greenlabs.layoutdemo.core.entity.Mahasiswa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import com.greenlabs.layoutdemo.core.common.Result;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;

/**
 * Created by Ivan-TI on 9/20/2017
 **/
@Service
public class MahasiswaService extends BaseService {

    @Autowired
    public MahasiswaDAO mahasiswaDAO;

    public Result save(final Mahasiswa mahasiswa){
        return transactionTemplate.execute(new TransactionCallback<Result>() {
            public Result doInTransaction(TransactionStatus transactionStatus) {
                try {
                    if(mahasiswa.getId() == null){
                        mahasiswaDAO.save(mahasiswa);
                    } else {
                        mahasiswaDAO.update(mahasiswa);
                    }

                } catch (DataAccessException dae) {
                    transactionStatus.setRollbackOnly();
                    throw dae;
                }
                return null;
            }
        });
    }

    public Result delete(final Mahasiswa mahasiswa){
        return transactionTemplate.execute(new TransactionCallback<Result>() {
            @Override
            public Result doInTransaction(TransactionStatus transactionStatus) {
                try {
                    mahasiswa.setId(mahasiswa.getId());
                    mahasiswaDAO.delete(mahasiswa);
                } catch (DataAccessException e) {
                    transactionStatus.setRollbackOnly();
                    throw e;
                }
                return null;
            }
        });
    }

}
