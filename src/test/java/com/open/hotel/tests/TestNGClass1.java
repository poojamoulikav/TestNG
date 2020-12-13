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

    }

    @Test
    public void search() {
        System.out.println("Class1 test2");
        HashMap<String, String> hmap = new HashMap<>();
        hmap.put("Location", "Sydney");
        hmap.put("Hotels", "Hotel Creek");
        hmap.put("Room Type ", "Standard");
        hmap.put("Number of Rooms", "1 - One");
        hmap.put("Check In Date", "17 / 07 / 2020");
        hmap.put("Check Out Date", "18 / 07 / 2020");
        hmap.put("Adults per Room", "1 - One");
        hmap.put("Children per Room", "2 - Two");

        Search search = new Search(getDriver(), "Search", "02");
        search.enterRoomSearchInfo(hmap);

    }
}
