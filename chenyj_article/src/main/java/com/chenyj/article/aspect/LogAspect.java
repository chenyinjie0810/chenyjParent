package com.chenyj.article.aspect;

import com.alibaba.fastjson.JSON;
import com.chenyj.article.annotation.PrintLog;
import com.chenyj.article.aop.SysLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/12/15 16:36
 * 陈银杰专属测试
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    /**
     * @desc: 定义类的切面
     * @author: chenyj
     * @date: 2019/12/15
     */
//    @Pointcut("execution(public * com.chenyj.article.controller..*.*(..))")
//    public void pointCut(){
//        System.out.println("日志输出1");
//    }

    /**
     * @desc: 用注解的方法定义切面
     * @author: chenyj
     * @date: 2019/12/15
     */
    @Pointcut(value = "@annotation(com.chenyj.article.annotation.PrintLog)")
    public void logCut(){ }

    /**
     * 打印传入参数
     * @param joinPoint
     * @param printLog
     */
    @Before("logCut() && @annotation(printLog)")
    public void PrintLog(JoinPoint joinPoint, PrintLog printLog){
        //获取日志类型
        int status = printLog.status();
        String title=printLog.value();
        //获取路径
        String path = joinPoint.getTarget().getClass().getName();
        //获取方法名称
        String name = joinPoint.getSignature().getName();
        //获取参数
        Object[] args = joinPoint.getArgs();
        SysLog sysLog=new SysLog();
        sysLog.setStatus(status);
        sysLog.setPath(path);
        sysLog.setName(name);
        sysLog.setTitle(title);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sysLog.setDate(simpleDateFormat.format(new Date()));
        List<Object> paramsList=new ArrayList<>();
        for (Object value:args){
            paramsList.add(value);
        }
        String params = JSON.toJSONString(paramsList);
        sysLog.setParams(params);
        log.info(sysLog.toString());
    }

    /**
     * @desc: 打印错误原因
     * @author: chenyj
     * @date: 2019/12/15
     * @param joinPoint
     * @param printLog
     * @param throwable
     */
    @AfterThrowing(value = "logCut() && @annotation(printLog)",throwing = "throwable")
    public void logThrow(JoinPoint joinPoint, PrintLog printLog,Throwable throwable){
        //获取日志类型
        int status = printLog.status();
        String title=printLog.value();
        //获取路径
        String path = joinPoint.getTarget().getClass().getName();
        //获取方法名称
        String name = joinPoint.getSignature().getName();
        SysLog sysLog=new SysLog();
        sysLog.setStatus(status);
        sysLog.setPath(path);
        sysLog.setName(name);
        sysLog.setTitle(title+"出错");
        sysLog.setError(throwable.getMessage());
        log.error(sysLog.toString());
    }
//    @Before("pointCut()")
//    public void logStart(){
//        System.out.println("日志输出2");
//    }
//
//    @After("pointCut()")
//    public void logEnd(){
//        System.out.println("日志输出3");
//    }
//    @AfterReturning("pointCut()")
//    public void logReturn(){
//        System.out.println("日志输出4");
//    }
//    @AfterThrowing("pointCut()")
//    public void logThrow(){
//        System.out.println("日志输出5");
//    }
//    @Around("pointCut()")
//    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        System.out.println("日志输出6");
//        Object proceed = proceedingJoinPoint.proceed();
//        System.out.println("日志输出7");
//        return proceed;
//    }
}
