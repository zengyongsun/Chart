package com.zy.chart;

import com.zy.chart.testdemo.LoginPresenter;
import com.zy.chart.testdemo.UserManager;

import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created by Administrator on 2017/5/15.
 */

public class LoginPresenterTest {

    @Test
    public void testLogin()throws Exception{
        LoginPresenter loginPresenter = new LoginPresenter();

        UserManager userManager = Mockito.mock(UserManager.class);

        loginPresenter.setmUserManager(userManager);

        loginPresenter.login("zhanghao","mimamima");

        Mockito.verify(userManager,Mockito.times(1)).performLogin("zhanghao","mimamima");
    }

}
