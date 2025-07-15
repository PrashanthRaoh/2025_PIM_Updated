package pim.automation.framework_PreETL_Update;

/************************************************
TC 001 - Updating BSA PIE record which is "On Hold (Rule Triggered)".
Descrption - This is Pre-ETL Update script which verifies what attributes to be checked.
 ************************************************/
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import common_functions.BaseTest;
import common_functions.ExcelManager;
import common_functions.Utils;
import pages.BSAPIE_Page;
import pages.DigitalAsset;
import pages.HomePage;
import pages.SearchPage2;
import pages.SummaryPage;

public class TC_001_Update_BSAPIE_record_OnHold_RuleTriggered extends BaseTest {
	public ExtentTest test;
	
	public String SheetName = "On Hold (Rule Triggered)";

	@Test(groups = { "BSAPIEowner" })
	public void BSAPIEOwner() throws InterruptedException, IOException {
		
		String className = this.getClass().getSimpleName();
		System.out.println(className);
		test = BaseTest.extentreport.createTest(className);
		test.assignAuthor(System.getProperty("user.name")).assignCategory("Regression").assignDevice(System.getenv("COMPUTERNAME"));

		homePage = new HomePage(driver);
		SearchPage2 searchPage = new SearchPage2(driver);
		SummaryPage summaryPage = new SummaryPage(driver);
		BSAPIE_Page BSAPIE_PO = new BSAPIE_Page(driver);
		DigitalAsset digitalssetPage = new DigitalAsset(driver);
		utils.waitForElement(() -> homePage.sellablematerialtabelement(), "clickable");

		test.pass("Home Page is displayed");
		test.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(Utils.Takescreenshot(driver)).build());
		utils.waitForElement(() -> homePage.BSAPIEUsecaseApprovalTab(), "visible");

		/**************************************************
		 * ***** Verify that logged in user is BSAPIEowner
		 **************************************************/
//		Thread.sleep(5000);
//		homePage.BSAPIEUsecaseApprovalTab().click();
//		Thread.sleep(5000);
//		test.pass("Clicked on Approval tab");
//		test.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(Utils.Takescreenshot(driver)).build());
//		Thread.sleep(2000);

		/********************************************
		 * Get number of items under use case approvals
		 ***************************************/
//		List<WebElement> summaryElements = driver.findElement(By.cssSelector("#app")).getShadowRoot()
//				.findElement(By.cssSelector("#contentViewManager")).getShadowRoot()
//				.findElement(By.cssSelector("[id^='currentApp_home_rs']")).getShadowRoot()
//				.findElement(By.cssSelector("[id^='app-dashboard-component-rs']")).getShadowRoot()
//				.findElement(By.cssSelector("rock-layout > rock-dashboard-widgets")).getShadowRoot()
//				.findElement(By.cssSelector("[id^='rs']")).getShadowRoot().findElement(By.cssSelector("#rock-my-todos"))
//				.getShadowRoot().findElement(By.cssSelector("[id^='rock-my-todos-component-rs']")).getShadowRoot()
//				.findElement(By.cssSelector("#rock-my-todos-tabs")).getShadowRoot()
//				.findElement(By.cssSelector("[id^='my-todo-summary-list-component-rs']")).getShadowRoot()
//				.findElements(By.cssSelector("pebble-list-view > pebble-list-item > my-todo-summary"));
//
//		System.out.println("Total items: " + summaryElements.size());
//
//		List<String> expectedItems = Arrays.asList("Pending Usecase Approval - BSA PIE","On Hold - BSA PIE (User Selected)", "On Hold - BSA PIE (Rule Triggered)");
//
//		Assert.assertEquals(summaryElements.size(), expectedItems.size(), "Item count mismatch");
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//
//		for (int i = 0; i < summaryElements.size(); i++) {
//			WebElement summary = summaryElements.get(i);
//			WebElement innerDiv = summary.getShadowRoot().findElement(By.cssSelector("#workflowMetadataContainer"));
//			String actualText = innerDiv.getText().trim();
//			System.out.println("Item " + (i + 1) + ":--" + actualText);
//			Assert.assertEquals(actualText, expectedItems.get(i), "Mismatch at item " + (i + 1));
//
//			if (actualText.contains("On Hold - BSA PIE (Rule Triggered)")) {
//				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", innerDiv);
//				try {
//					innerDiv.click();
//				} catch (Exception e) {
//					js.executeScript("arguments[0].click();", innerDiv);
//				}
//				Thread.sleep(5000);
//				break;
//			}
//		}
//		test.pass("BSA PIE Use case Approval entities listed ");
//		test.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(Utils.Takescreenshot(driver)).build());

		/***************************************
		 * ***** Click on On Hold - BSA PIE(Rule Triggered) ****
		 ***************************************/
		homePage.clickSearch_Products_Button().click();
		Thread.sleep(5000);

		utils.waitForElement(() -> searchPage.getgrid(), "clickable");
		test.pass("Search page grid displayed after clicking on On Hold - BSA PIE");
		test.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(Utils.Takescreenshot(driver)).build());

		/**************************************************
		 * --------- Get Row count------- *
		 ********************************************************/
		searchPage.searchthingdomain_Input_Mat_Id().click();
		searchPage.searchthingdomain_Input_Mat_Id().clear();
		searchPage.searchthingdomain_Input_Mat_Id().sendKeys("000000000100132629");
		searchPage.searchthingdomain_Input_Mat_Id().sendKeys(Keys.ENTER);
		
		Thread.sleep(5000);
		
		Actions actions = new Actions(driver);
		WebElement rowsredefined = driver.findElement(By.cssSelector("#app")).getShadowRoot()
				.findElement(By.cssSelector("#contentViewManager")).getShadowRoot()
				.findElement(By.cssSelector("[id^='currentApp_search-thing_']")).getShadowRoot()
				.findElement(By.cssSelector("[id^='app-entity-discovery-component-']")).getShadowRoot()
				.findElement(By.cssSelector("#entitySearchDiscoveryGrid")).getShadowRoot()
				.findElement(By.cssSelector("#entitySearchGrid")).getShadowRoot()
				.findElement(By.cssSelector("#entityGrid")).getShadowRoot()
				.findElement(By.cssSelector("#pebbleGridContainer > pebble-grid")).getShadowRoot()
				.findElement(By.cssSelector("#grid"));

		List<WebElement> arrrowsdefined = rowsredefined.getShadowRoot().findElements(By.cssSelector(
				"#lit-grid > div > div.ag-root-wrapper-body.ag-layout-normal.ag-focus-managed > div.ag-root.ag-unselectable.ag-layout-normal > div.ag-body-viewport.ag-layout-normal.ag-row-no-animation > div.ag-center-cols-clipper > div > div > div"));

		System.out.println("Total rows after clicking on On Hold - BSA PIE -- " + arrrowsdefined.size());
		test.pass("Rows after after clicking on On Hold - BSA PIE appeared");
		test.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(Utils.Takescreenshot(driver)).build());
		assertTrue("There should be results after applying filters", arrrowsdefined.size() > 0);

		WebElement RowByRow = arrrowsdefined.get(0);
		String SellableMaterialDescription = RowByRow.findElement(By.cssSelector("div[col-id='sellablematerialdescription']")).getText();
		String matid = RowByRow.findElement(By.cssSelector("div[col-id='sellablematerialid']")).getText();
		System.out.println("Material ID -- " + matid + " Material Description --" + SellableMaterialDescription);

		/*************************************************
		 * --------- Click on the materialid from the result------- *
		 ************************************************/
		WebElement matidElement = RowByRow.findElement(By.cssSelector("div[col-id='sellablematerialid']"));
		actions.moveToElement(RowByRow).build().perform();
		Thread.sleep(2000);
		matidElement.click();
		Thread.sleep(3000);
		utils.waitForElement(() -> summaryPage.Things_INeedToFix(), "visible");
		test.pass("Material ID -- " + matid + " Material Description --" + SellableMaterialDescription + " is selected for completion");
		test.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath(Utils.Takescreenshot(driver)).build());
		Thread.sleep(2000);

		/*************************************************
		 * --------- Read Attributes from sheet name and enter the same attrib value in the search
		 ************************************************/
		List<String> attribList = ExcelManager.GetAttributes_Col_Values(SheetName);
			System.out.println("****************");
			System.out.println("**** Attribute List is \n *****" + attribList);
			System.out.println("****************");
			
			/*************************************************
			 * --------- For Loop of the attribs
			 ************************************************/
		for (int i = 0; i < attribList.size(); i++) {
			/*************************************************
			 * --Click on Attributes tab and Use case value -- *
			 ************************************************/
			BSAPIE_PO.dropdownWrapper().click();
			Thread.sleep(1000);
			digitalssetPage.Use_Case_Attributes_selection().click();
			Thread.sleep(2000);
			test.pass("Use case attributes page is displayed");
			test.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath(Utils.Takescreenshot(driver)).build());
			Actions actions2 = new Actions(driver);
			summaryPage.SearchIcon().click();
			Thread.sleep(1000);
			summaryPage.SearchInputfield().sendKeys(attribList.get(i));
			Thread.sleep(1000);
			actions2.moveToElement(summaryPage.SearchInputfield()).sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(3000);
			test.pass(attribList.get(i) + " Attribute entered");
			test.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath(Utils.Takescreenshot(driver)).build());
			
			
			WebElement targetElement = null;
			try {
			    targetElement = driver.findElement(By.cssSelector("#app"))
			        .getShadowRoot().findElement(By.cssSelector("#contentViewManager"))
			        .getShadowRoot().findElement(By.cssSelector("[id^='currentApp_entity-manage_rs']"))
			        .getShadowRoot().findElement(By.cssSelector("[id^='app-entity-manage-component-rs']"))
			        .getShadowRoot().findElement(By.cssSelector("#rockDetailTabs"))
			        .getShadowRoot().findElement(By.cssSelector("#rockTabs"))
			        .getShadowRoot().findElement(By.cssSelector("[id^='rock-wizard-manage-component-rs']"))
			        .getShadowRoot().findElement(By.cssSelector("[id^='rock-attribute-manage-component-rs']"))
			        .getShadowRoot().findElement(By.cssSelector("#rock-attribute-list-container > rock-attribute-list"))
			        .getShadowRoot().findElement(By.cssSelector("[id^='rs']"))
			        .getShadowRoot().findElement(By.cssSelector("#input"))
			        .getShadowRoot().findElement(By.cssSelector("bedrock-lov"))
			        .getShadowRoot().findElement(By.cssSelector("#collectionContainer"))
			        .getShadowRoot().findElement(By.cssSelector("#collection_container_wrapper > div.d-flex > div.tags-container"));

			    System.out.println("Attribute list element found.");

			} catch (Exception e) {
			    try {
			        targetElement = driver.findElement(By.cssSelector("#app"))
			            .getShadowRoot().findElement(By.cssSelector("#contentViewManager"))
			            .getShadowRoot().findElement(By.cssSelector("[id^='currentApp_entity-manage_rs']"))
			            .getShadowRoot().findElement(By.cssSelector("[id^='app-entity-manage-component-rs']"))
			            .getShadowRoot().findElement(By.cssSelector("#rockDetailTabs"))
			            .getShadowRoot().findElement(By.cssSelector("#rockTabs"))
			            .getShadowRoot().findElement(By.cssSelector("[id^='rock-wizard-manage-component-rs']"))
			            .getShadowRoot().findElement(By.cssSelector(".base-grid-structure > .base-grid-structure-child-2 > #wizard-container > .base-grid-structure-child-2 > div > .base-grid-structure-child-2 > #step-container-manage > [name='QuickSearchAttributes']"))
			            .getShadowRoot().findElement(By.cssSelector(".base-grid-structure > div.base-grid-structure-child-1 > [align='center']"));

			        System.out.println(" 'Attributes are not available' element found.");

			    } catch (Exception inner) {
			        System.out.println("❌ Neither attribute list nor 'attributes not available' element found.");
			    }
			}
			if (targetElement != null) {
			    System.out.println("Final element text: " + targetElement.getText());
				test.pass("Status of the " + attribList.get(i) + "  is shown as : - " + targetElement.getText());
				test.log(Status.INFO,MediaEntityBuilder.createScreenCaptureFromPath(Utils.Takescreenshot(driver)).build());
				ExcelManager.UpdatePostETLUpdate(SheetName, attribList.get(i), "Pre_ETLUpdate",targetElement.getText());
				BSAPIE_PO.Tabclose_Xmark().click();
				Thread.sleep(4000);
				
			} else {
			    System.out.println("🔴 No target element to act upon.");
			    test.fail("No element found" );
				test.log(Status.INFO,MediaEntityBuilder.createScreenCaptureFromPath(Utils.Takescreenshot(driver)).build());
			}
		}

	}
}