package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    private void forDaoPackage(){

    }

    // criar um pointcut para o metodo getter
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
    private void getter(){

    }

    // criar um pointcut para o metodo setter
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
    private void setter(){

    }
    // criar um pointcut para excluir os metodos getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter(){

    }


    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(){

        System.out.println("\n=====>>> Executing @Before advice on method");

    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics(){
        System.out.println("\n=====>>> Performing API analytics");

    }
}
