package com.open.hotel.tests;

import com.open.hotel.loadConfig.Config;
import com.open.hotel.pages.Login;
import com.open.hotel.pages.Search;
import org.testng.annotations.*;

import java.util.HashMap;

public class TestNGClass1 extends BaseClass {

    @Test
    public void login() throws Exception {
        System.out.println("Class1 test1");
        Login login = new Login(getDriver(), "login", "01");
        login.lauchApplication();
        String Username = Config.properties.getProperty("QAUsername");
        String Password = Config.properties.getProperty("QAPassword");
        login.login(Username, Password);
        login.LogOut();

    }

    @Test
    public void login1() throws Exception {
        System.out.println("Class1 test2");
        Login login = new Login(getDriver(), "login", "01");
        login.lauchApplication();
        String Username = Config.properties.getProperty("QAUsername");
        String Password = Config.properties.getProperty("QAPassword");
        login.login(Username, Password);
        login.LogOut();

    }
}
