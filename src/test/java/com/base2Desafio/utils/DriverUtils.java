package com.base2Desafio.utils;

import com.base2Desafio.GlobalParameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverUtils {

    public static WebDriver DRIVER = null;
    private static String downloadPath = GlobalParameters.DOWNLOAD_DEFAULT_PATH;

    public static void createInstance(){
        String browser = GlobalParameters.BROWSER_DEFAULT;
        String execution = GlobalParameters.EXECUTION;

        if (DRIVER ==null){
            if(execution.equals("local")){
                if(browser.equals("chrome")){
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("no-sandbox");
                    chromeOptions.addArguments("--allow-running-insecure-content");
                    chromeOptions.addArguments("--lang=pt-BR");
                    chromeOptions.addArguments("download.default_directory", downloadPath);
                    DRIVER = new ChromeDriver(chromeOptions);

                }else if(browser.equals("chromeHeadless")){
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("download.default_directory", downloadPath);
                    chromeOptions.addArguments("--headless");
                    DRIVER = new ChromeDriver(chromeOptions);

                }else{
                    try{
                        throw new Exception("O browser informado não existe ou não é suportado pela automação");
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void quitInstace(){
        DRIVER.quit();
        DRIVER = null;
    }
}
