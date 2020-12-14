package com.open.hotel.tests;

import com.open.hotel.loadConfig.Config;
import com.open.hotel.pages.Login;
import com.open.hotel.pages.Search;
import org.testng.annotations.Test;

import java.util.HashMap;

public class TestNGClass3 extends BaseClass {

    @Test
    public void search() throws Exception {
        System.out.println("Class2 test1");
        Login login = new Login(getDriver(), "search", "02");
        login.lauchApplication();
        String Username = Config.properties.getProperty("QAUsername");
        String Password = Config.properties.getProperty("QAPassword");
        login.login(Username, Password);
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
        login.LogOut();
    }
    @Test
    public void search1() throws Exception {
        System.out.println("Class2 test2");
        Login login = new Login(getDriver(), "search", "02");
        login.lauchApplication();
        String Username = Config.properties.getProperty("QAUsername");
        String Password = Config.properties.getProperty("QAPassword");
        login.login(Username, Password);
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
        login.LogOut();
    }
}
