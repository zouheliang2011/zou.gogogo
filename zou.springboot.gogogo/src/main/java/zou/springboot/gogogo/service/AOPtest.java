package zou.springboot.gogogo.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/** 
 * @Before  在切入点方法执行前执行
 * @After  在切入点方法执行后执行，包括抛异常，相当于finally 
 * @AfterReturnning  同上，但不包括抛异常
 * @AfterThrowing  在切入点方法抛异常后执行
 * @Around  切入点前、后都执行，必须调用 ProceedingJoinPoint.proceed()继续往下走  这里要注意，
 * 有一次测试他的before还在注解Before之前执行，after也是在注解After之前执行
 */
@Aspect  //1. 定义切面类
@Configuration
public class AOPtest {

	private final static Logger log = LoggerFactory.getLogger(AOPtest.class);
	/**
     * 定义AOP扫描路径
     * 第一个注解只扫描aopTest方法
     */
    //@Pointcut("execution(public * com.aston.reader.controller.StudentController.aopTest())") 
	//下面是所有controller方法都会被拦截
    @Pointcut("execution(public * zou.springboot.gogogo.controller.UserController.*())")
    public void log(){}
    
    //定义cutpoint对应的切入点方法实现
    @Around("log()")  //3. 编写处理方法
    public Object aroundService(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("begin aroundService");
        long start = System.currentTimeMillis();


        Object thing = joinPoint.proceed();


        long end = System.currentTimeMillis();
        log.info( "end cost=" + (end - start));


        return thing;
    }
    
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容

        // 记录下请求内容
        log.info(" doBefore CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

    }
    
    @After("log()")
    public void doAfter(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容

        // 记录下请求内容
        log.info(" doAfter CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

    }

    @AfterReturning(returning = "ret", pointcut = "log()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
    	log.info(" doAfterReturning RESPONSE : " + ret);
    }

}
