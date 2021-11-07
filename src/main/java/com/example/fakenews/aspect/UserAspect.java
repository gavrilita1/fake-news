package com.example.fakenews.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class UserAspect {

    // UserController.saveUser()
    @Before("execution(* com.example.fakenews.controller.UserController.saveUser(..))")
    public void beforeSaveUser() {
        System.out.println("UserController called saveUser()");
    }

    @After("execution(* com.example.fakenews.controller.UserController.saveUser(..))")
    public void afterSaveUser() {
        System.out.println("UserController finished executing saveUser()");
    }


    // UserController.addUsers()
    @Before("execution(* com.example.fakenews.controller.UserController.addUsers(..))")
    public void beforeAddUsers() {
        System.out.println("UserController called addUsers()");
    }
    @After("execution(* com.example.fakenews.controller.UserController.addUsers(..))")
    public void afterAddUsers() {
        System.out.println("UserController finished executing addUsers()");
    }

    // UserController.getAllUsers()
    @Before("execution(* com.example.fakenews.controller.UserController.getAllUsers(..))")
    public void beforeGetAllUsers() {
        System.out.println("UserController called getAllUsers()");
    }

    @After("execution(* com.example.fakenews.controller.UserController.getAllUsers(..))")
    public void afterGetAllUsers() {
        System.out.println("UserController finished executing getAllUsers()");
    }

    // UserController.getUser()
    @Before("execution(* com.example.fakenews.controller.UserController.getUser(..))")
    public void beforeGetUser() {
        System.out.println("UserController called getUser()");
    }

    @After("execution(* com.example.fakenews.controller.UserController.getUser(..))")
    public void afterGetUser() {
        System.out.println("UserController finished executing getUser()");
    }

    // UserController.updateUser()
    @Before("execution(* com.example.fakenews.controller.UserController.updateUser(..))")
    public void beforeUpdateUser() {
        System.out.println("UserController called updateUser()");
    }

    @After("execution(* com.example.fakenews.controller.UserController.updateUser(..))")
    public void afterUpdateUser() {
        System.out.println("UserController finished executing updateUser()");
    }

    // UserController.deleteUser()
    @Before("execution(* com.example.fakenews.controller.UserController.deleteUser(..))")
    public void beforeDeleteUser() {
        System.out.println("UserController called deleteUser()");
    }

    @After("execution(* com.example.fakenews.controller.UserController.deleteUser(..))")
    public void afterDeleteUser() {
        System.out.println("UserController finished executing deleteUser()");
    }
}