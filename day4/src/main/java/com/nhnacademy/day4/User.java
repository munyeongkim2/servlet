package com.nhnacademy.day4;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class User{
    private String userName;
    private int userAge;
    public User(){
    }
    public User(String userName, int userAge) {
        this.userName = userName;
        this.userAge = userAge;
    }
    public String getUserName() {
        return userName;
    }
    public int getUserAge() {
        return userAge;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }
    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userAge=" + userAge +
                '}';
    }

    public static void main(String[] args) {
        try {
            Class clazz = Class.forName(User.class.getName());
            Object user =clazz.getDeclaredConstructor().newInstance();
            Field userNameField =clazz.getDeclaredField("userName");
            userNameField.setAccessible(true);
            userNameField.set(user, "marco");
            String userName = (String) userNameField.get(user);
            Field userAgeField =clazz.getDeclaredField("userAge");
            userAgeField.setAccessible(true);
            userAgeField.set(user, 30);
            int userAge = userAgeField.getInt(user);
            System.out.println("userName:" + userName);
            System.out.println("userAge:" + userAge);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}