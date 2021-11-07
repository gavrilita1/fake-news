package com.example.fakenews.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class CheckAspect {

    // CheckController.saveCheck()
    @Before("execution(* com.example.fakenews.controller.CheckController.saveCheck(..))")
    public void beforeSaveCheck() {
        System.out.println("CheckController called saveCheck()");
    }

    @After("execution(* com.example.fakenews.controller.CheckController.saveCheck(..))")
    public void afterSaveCheck() {
        System.out.println("CheckController finished executing saveCheck()");
    }

    // CheckController.addChecks()
    @Before("execution(* com.example.fakenews.controller.CheckController.addChecks(..))")
    public void beforeAddChecks() {
        System.out.println("CheckController called addChecks()");
    }
    @After("execution(* com.example.fakenews.controller.CheckController.addChecks(..))")
    public void afterAddChecks() {
        System.out.println("CheckController finished executing addChecks()");
    }

    // CheckController.getAllChecks()
    @Before("execution(* com.example.fakenews.controller.CheckController.getAllChecks(..))")
    public void beforeGetAllChecks() {
        System.out.println("CheckController called getAllChecks()");
    }

    @After("execution(* com.example.fakenews.controller.CheckController.getAllChecks(..))")
    public void afterGetAllChecks() {
        System.out.println("CheckController finished executing getAllChecks()");
    }

    // CheckController.getCheck()
    @Before("execution(* com.example.fakenews.controller.CheckController.getCheck(..))")
    public void beforeGetCheck() {
        System.out.println("CheckController called getCheck()");
    }

    @After("execution(* com.example.fakenews.controller.CheckController.getCheck(..))")
    public void afterGetCheck() {
        System.out.println("CheckController finished executing getCheck()");
    }

    // CheckController.updateCheck()
    @Before("execution(* com.example.fakenews.controller.CheckController.updateCheck(..))")
    public void beforeUpdateCheck() {
        System.out.println("CheckController called updateCheck()");
    }

    @After("execution(* com.example.fakenews.controller.CheckController.updateCheck(..))")
    public void afterUpdateCheck() {
        System.out.println("CheckController finished executing updateCheck()");
    }

    // CheckController.deleteCheck()
    @Before("execution(* com.example.fakenews.controller.CheckController.deleteCheck(..))")
    public void beforeDeleteCheck() {
        System.out.println("CheckController called deleteCheck()");
    }

    @After("execution(* com.example.fakenews.controller.CheckController.deleteCheck(..))")
    public void afterDeleteCheck() {
        System.out.println("CheckController finished executing deleteCheck()");
    }
}
