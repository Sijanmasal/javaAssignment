package com.bookstoremanager;

public class Auth {
    public boolean checkLogin(String userName, String password){
        if(userName.equals("sijan") && password.equals("masal")){
            return true;
        }
        return false;
    }
}
