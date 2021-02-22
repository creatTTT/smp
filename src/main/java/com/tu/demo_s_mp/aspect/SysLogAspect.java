package com.tu.demo_s_mp.aspect;

import com.alibaba.fastjson.JSON;
import com.tu.demo_s_mp.annotation.SysLogAnnotation;
import com.tu.demo_s_mp.entity.Syslog;
import com.tu.demo_s_mp.service.ISyslogService;
import com.tu.demo_s_mp.service.IUserService;
import com.tu.demo_s_mp.util.IPUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

/**
 * Created by Administrator on 2021/2/22 0022.
 */

@Aspect
@Component
public class SysLogAspect {

    @Autowired
    IUserService userService;

    @Autowired
    ISyslogService syslogService;


    @Around("@annotation(com.tu.demo_s_mp.annotation.SysLogAnnotation)")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        //执行方法
        Object result = point.proceed();
        //执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;

        //保存日志
        saveSysLog(point, time);

        return result;
    }

    public void saveSysLog(ProceedingJoinPoint joinPoint, long time){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        Syslog syslog = new Syslog();
        SysLogAnnotation sysLogAnnoation = method.getAnnotation(SysLogAnnotation.class);
        if(sysLogAnnoation != null){
            //注解上的描述
            syslog.setOperation(sysLogAnnoation.value());
        }

        //请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        syslog.setMethod(className + "." + methodName + "()");

        //请求的参数
        Object[] args = joinPoint.getArgs();
        try{
            String params = JSON.toJSONString(args);
            syslog.setParams(params);
        }catch (Exception e){

        }

        //获取request
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //设置IP地址
        syslog.setIp(IPUtil.getIpAddr(request));





        //用户名
        syslog.setNickname("zhangsan");
        syslog.setUsername("zhangsan");




        syslog.setTime(time);
        syslog.setCreateDate(LocalDateTime.now());
        //保存系统日志
        syslogService.save(syslog);
    }
}
