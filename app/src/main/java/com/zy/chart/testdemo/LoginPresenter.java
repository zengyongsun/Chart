package com.zy.chart.testdemo;

/**
 * Created by Administrator on 2017/5/15.
 */

public class LoginPresenter {

    private UserManager mUserManager = new UserManager();

    public void login(String name, String password) {
        if (name == null || name.length() == 0) {
            return;
        }
        if (password == null || password.length() < 6) {
            return;
        }
        mUserManager.performLogin(name, password);
    }

    public void setmUserManager(UserManager mUserManager) {
        this.mUserManager = mUserManager;
    }
}
