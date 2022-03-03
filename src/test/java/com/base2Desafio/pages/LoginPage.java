package com.base2Desafio.pages;

import com.base2Desafio.bases.PageBase;
import org.openqa.selenium.By;

public class LoginPage extends PageBase {

    // Mapeamento dos seletores
    By usernameField = By.name("username");
    By passwordField = By.name("password");
    By buttonLogin = By.className("button");


    //Actions
    public void fillUsername (String username){
        sendKeys(usernameField, username);
    }


    public void fillPassword (String password){
        sendKeys(passwordField, password);
    }

    public void clickLogin(){
        click(buttonLogin);
    }

}
