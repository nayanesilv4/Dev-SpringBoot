package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;


@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(
            ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{

        String method = theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n=======>>> Executing @Around on method: " + method);

        long begin = System.currentTimeMillis();

        Object result = null;

        try {
           result = theProceedingJoinPoint.proceed();
        }
        catch (Exception exc){

            System.out.println(exc.getMessage());

           throw exc;

        }

        long end = System.currentTimeMillis();

        long duration = end - begin;
        System.out.println("\n=====> Duration: " + duration/1000.0 + "seconds");

        return  result;
    }

    @After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoint){

        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=======>>> Executing @After (finally) on method: " + method);

    }

    @AfterThrowing(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc){

        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=======>>> Executing @AfterThrowing on method: " + method);

        System.out.println("\n=======>>> the exception is: " + theExc);
    }


    @AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
    public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint, List<Account> result){

        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=======>>> Executing @AfterReturning on method: " + method);

        System.out.println("\n=======>>> Result is: " + result);

        convertAccountNamesToUpperCase(result);

        System.out.println("\n=======>>> Result is: " + result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {

        for(Account tempAccount : result){
            String theUpperName = tempAccount.getName().toUpperCase();

            tempAccount.setName(theUpperName);
        }

    }

    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint){

        System.out.println("\n=====>>> Executing @Before advice on method");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();

        System.out.println("Method: " + methodSignature);

        // display method arguments

        //get args
        Object[] args = theJoinPoint.getArgs();

        // loop thru args
        for (Object tempArg : args){
            System.out.println(tempArg);

            if(tempArg instanceof Account){

                // downcast and print Account specific stuff
                Account theAccount = (Account) tempArg;

                System.out.println("account name: " + theAccount.getName());
                System.out.println("account level: " + theAccount.getLevel());
            }
        }

    }

}
