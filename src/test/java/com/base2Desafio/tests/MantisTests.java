package com.base2Desafio.tests;

import com.base2Desafio.bases.PageBase;
import com.base2Desafio.bases.TestBase;
import com.base2Desafio.pages.*;
import com.base2Desafio.utils.DriverUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MantisTests extends TestBase {
    //Objects
    private HomePage homePage;
    private ReportIssuePage reportIssuePage;
    private ViewIssuesPage viewIssuesPage;
    private PageBase page;
    private String summaryEdited = "Treinamento base"+ RandomStringUtils.randomNumeric(2);


    @Before
    public void start(){
        homePage = new HomePage();
        page = new PageBase();
    }

    //Tests
    @Test
    public void test_1_createReport() {

        //Selecionando a opção de criar ocorrência
        String summary = "Treinamento base"+ RandomStringUtils.randomNumeric(2);
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
        reportIssuePage.fillSummary(summary);
        reportIssuePage.fillDescription("descrevendo o teste");
        reportIssuePage.clickReport();

        // Verificando ocorrências criadas
        homePage.clickViewIssues();
        viewIssuesPage = new ViewIssuesPage();
        viewIssuesPage.fillReporter();
        viewIssuesPage.selectClickReporter("bervelly.nobrega");
        viewIssuesPage.fieldFillSearch(summary);
        viewIssuesPage.selectFilter();
        Assert.assertEquals(summary, page.getText(By.xpath("//*[@id=\"buglist\"]/tbody/tr[4]/td[11]")));


    }

    @Test
    public void test_2_invalidCreateReport() {
        // Criando ocorrência inválida
        homePage.clickReportIssue();
        reportIssuePage = new ReportIssuePage();
        reportIssuePage.clickCategory();
        reportIssuePage.selectCategoryOptions("[All Projects] a");
        reportIssuePage.clickReproducibility();
        reportIssuePage.selectReproducibilityOptions("always");
        reportIssuePage.clickSeverity();
        reportIssuePage.selectSeverityOptions("feature");
        reportIssuePage.clickSelectAssign();
        reportIssuePage.chooseAssign("bervelly.nobrega");
        reportIssuePage.fillDescription("descrevendo o teste");
        reportIssuePage.clickReport();
        Assert.assertEquals("APPLICATION ERROR #11",page.getText(By.className("form-title")));

    }

    @Test
    public void test_3_editReport() {


        // Editar ocorrências
        viewIssuesPage = new ViewIssuesPage();
        homePage.clickViewIssues();
        viewIssuesPage.editReport();
        DriverUtils.DRIVER.findElement(By.name("summary")).clear();
        viewIssuesPage.editNewSummary(summaryEdited);
        viewIssuesPage.clickEdit();

        // Verificando ocorrências editadas
        homePage.clickViewIssues();
        viewIssuesPage = new ViewIssuesPage();
        viewIssuesPage.fillReporter();
        viewIssuesPage.selectClickReporter("bervelly.nobrega");
        viewIssuesPage.fieldFillSearch(summaryEdited);
        viewIssuesPage.selectFilter();
        Assert.assertEquals(summaryEdited, page.getText(By.xpath("//*[@id=\"buglist\"]/tbody/tr[4]/td[11]")));
    }

    @Test
    public void test_5_deleteReport() {

        // Excluir ocorrências
        viewIssuesPage = new ViewIssuesPage();
        homePage.clickViewIssues();
        viewIssuesPage.fillReporter();
        viewIssuesPage.selectClickReporter("bervelly.nobrega");
        viewIssuesPage.clickCheckBox();
        viewIssuesPage.clickSelectDelete("Delete");
        viewIssuesPage.selectOk();
        viewIssuesPage.clickDeleteIssue();

    }

    @Test
    public void test_4_resolveReport() {

        // Resolver ocorrência
        viewIssuesPage = new ViewIssuesPage();
        homePage.clickViewIssues();
        viewIssuesPage.fillReporter();
        viewIssuesPage.selectClickReporter("bervelly.nobrega");
        viewIssuesPage.selectFilter();
        viewIssuesPage.clickCheckBox();
        viewIssuesPage.checkResolve("Resolve");
        viewIssuesPage.selectOk();
        viewIssuesPage.selectChooseResolve("not fixable");
        viewIssuesPage.buttonResolveIssue();
        }


    }

