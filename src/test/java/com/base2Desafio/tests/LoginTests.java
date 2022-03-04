package com.base2Desafio.tests;

import com.base2Desafio.GlobalParameters;
import com.base2Desafio.bases.TestBase;
import com.base2Desafio.pages.*;
import com.base2Desafio.utils.DriverUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LoginTests extends TestBase {
    //Objects
    LoginPage loginPage;
    HomePage homePage;
    ReportIssuePage reportIssuePage;
    ViewIssuesPage viewIssuesPage;

    //Tests
    @Test
    public void Login() {
        //Realizar login
        loginPage = new LoginPage();
        loginPage.fillUsername(GlobalParameters.USERNAME);
        loginPage.fillPassword(GlobalParameters.SENHA_GERAL);
        loginPage.clickLogin();
        Assert.assertEquals("My View", DriverUtils.DRIVER.findElement(By.linkText("My View")).getText());


       //Selecionando a opção de criar ocorrência
       homePage = new HomePage();
       homePage.clickReportIssue();


       //Preenchendo campos de criar ocorrência
       reportIssuePage = new ReportIssuePage();
       reportIssuePage.clickCategory();
       reportIssuePage.selectCategoryOptions("[All Projects] a");
       reportIssuePage.clickReproducibility();
       reportIssuePage.selectReproducibilityOptions("always");
       reportIssuePage.clickSeverity();
       reportIssuePage.selectSeverityOptions("feature");
       reportIssuePage.clickSelectAssign();
       reportIssuePage.chooseAssign("bervelly.nobrega");
       reportIssuePage.fillSummary("Bervelly1");
       reportIssuePage.fillDescription("descrevendo o teste");
       reportIssuePage.clickReport();

       // Verificando ocorrências criadas
        homePage.clickViewIssues();
        viewIssuesPage = new ViewIssuesPage();
        viewIssuesPage.fillReporter("Bervelly1");
        viewIssuesPage.selectClickSearch();

       // Editar ocorrências
        viewIssuesPage.editReport();
        viewIssuesPage.editNewSummary("Bervelly2");
        viewIssuesPage.clickEdit();
        homePage.clickViewIssues();
        viewIssuesPage.fillReporter("Bervelly2");
        viewIssuesPage.selectClickSearch();

       // Excluir ocorrências
        homePage.clickViewIssues();
        viewIssuesPage.fillReporter("Bervelly1");
        viewIssuesPage.selectClickSearch();
        viewIssuesPage.clickDelete();
        viewIssuesPage.clickSelectDelete("Delete");
        viewIssuesPage.selectOk();
        viewIssuesPage.clickDeleteIssue();
        homePage.clickViewIssues();
        viewIssuesPage.fillReporter("Bervelly1");
        viewIssuesPage.selectClickSearch();

       // Resolver ocorrência
        homePage.clickViewIssues();
        viewIssuesPage.fillReporter("Bervelly1");
        viewIssuesPage.selectClickSearch();
        viewIssuesPage.clickDelete();
        viewIssuesPage.checkResolve("Resolve");
        viewIssuesPage.selectOk();
        viewIssuesPage.selectChooseResolve("not fixable");
        viewIssuesPage.buttonResolveIssue();
        viewIssuesPage.fillReporter("Bervelly1");
        viewIssuesPage.selectClickSearch();






    }
}
