package com.base2Desafio.bases;

import com.base2Desafio.GlobalParameters;
import com.base2Desafio.utils.DriverUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class TestBase {
    @BeforeClass
    public static void beforeSuite(){
        new GlobalParameters();
    }

    @Before
    public void beforeTest(){
        DriverUtils.createInstance();
        DriverUtils.DRIVER.manage().window().maximize();
        DriverUtils.DRIVER.navigate().to(GlobalParameters.URL_DEFAULT);
    }

    @After
    public void afterTest(){
        DriverUtils.quitInstace();
    }

    @AfterClass
    public static void afterSuite(){
    }
}
