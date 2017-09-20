package com.greenlabs.layoutdemo.core.aspect;

import com.greenlabs.layoutdemo.core.AppCore;
import com.greenlabs.layoutdemo.core.common.Result;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;

/**
 * Created by Ivan-TI on 9/20/2017
 **/
@Aspect
@Component
public class AspectService {

    @Around("execution(* com.greenlabs.layoutdemo.core.service.*.save(..))")
    public Result processSaveTransaction(ProceedingJoinPoint joinPoint) throws Throwable{
        AppCore.getLogger(this).info("***AspectJ*** save is catch !! intercepted : "+joinPoint.getSignature());

        return new Result(validateSaveMethod(joinPoint));
    }

    public String validateSaveMethod(ProceedingJoinPoint joinPoint) throws Throwable{
        try {
            joinPoint.proceed();
            return Result.SAVE_SUCCESS;
        } catch (DuplicateKeyException dke) {
            AppCore.getLogger(this).error(dke.getMessage());
            return Result.SAVE_DATA_EXIST;
        }
    }

    @Around("execution(* com.greenlabs.layoutdemo.core.service.*.delete(..))")
    public Result processDeleteTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
        AppCore.getLogger(this).info("***AspectJ*** delete is catch !! intercepted : "+joinPoint.getSignature());
        return new Result(validateSaveMethod(joinPoint));
    }

    public String validateDeleteMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            joinPoint.proceed();
            return Result.DELETE_SUCCESS;
        } catch (DataAccessException dae) {
            AppCore.getLogger(this).error(dae.getMessage());
            return Result.DELETE_SUCCESS;
        }
    }

}
