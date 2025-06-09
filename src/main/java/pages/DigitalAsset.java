package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DigitalAsset {
	private WebDriver driver;
	private By searchInputField = By.cssSelector("#app");

	public DigitalAsset(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement common_element() {
		return driver.findElement(searchInputField).getShadowRoot()
				.findElement(By.cssSelector("#contentViewManager")).getShadowRoot()
				.findElement(By.cssSelector("[id^='currentApp_entity-manage_rs']")).getShadowRoot()
				.findElement(By.cssSelector("[id^='app-entity-manage-component-rs']")).getShadowRoot()
				.findElement(By.cssSelector("#rockDetailTabs"));
	}

	public WebElement HasNoorImagesFiltericon() {
		return driver.findElement(By.cssSelector("#app")).getShadowRoot()
				.findElement(By.cssSelector("#contentViewManager")).getShadowRoot()
				.findElement(By.cssSelector("[id^='currentApp_search-thing_rs']")).getShadowRoot()
				.findElement(By.cssSelector("[id^='app-entity-discovery-component-rs']")).getShadowRoot()
				.findElement(By.cssSelector("#entitySearchDiscoveryGrid")).getShadowRoot()
				.findElement(By.cssSelector("[id^='rs']")).getShadowRoot()
				.findElement(By.cssSelector("#simpleButton > pebble-icon"));
	}

	public WebElement AdvanceSearch_Dropdown() {
		return driver.findElement(By.cssSelector("#app")).getShadowRoot()
				.findElement(By.cssSelector("#contentViewManager")).getShadowRoot()
				.findElement(By.cssSelector("[id^='currentApp_search-thing_rs']")).getShadowRoot()
				.findElement(By.cssSelector("[id^='app-entity-discovery-component-rs']")).getShadowRoot()
				.findElement(By.cssSelector("#entitySearchDiscoveryGrid")).getShadowRoot()
				.findElement(By.cssSelector("[id^='rs']")).getShadowRoot()
				.findElement(By.cssSelector("#simpleButton > pebble-icon"));
	}

	public WebElement generalDropdown_First() {
		return driver.findElement(By.cssSelector("#app")).getShadowRoot()
				.findElement(By.cssSelector("#contentViewManager")).getShadowRoot()
				.findElement(By.cssSelector("[id^='currentApp_search-thing_rs']")).getShadowRoot()
				.findElement(By.cssSelector("[id^='app-entity-discovery-component-rs']")).getShadowRoot()
				.findElement(By.cssSelector("#entitySearchDiscoveryGrid")).getShadowRoot()
				.findElement(By.cssSelector("#queryBuilder"));
	}

	public WebElement generalDropdown_second() {
		return generalDropdown_First().getShadowRoot().findElement(By.cssSelector("#operators"));
	}

	public WebElement HavingNoImagesFilterDropdownValue() {
		return generalDropdown_second().getShadowRoot()
				.findElement(By.cssSelector("#eds_pebbleItem_itemSelected_havingno > div"));
	}

	public WebElement HasFilterimagesdropdown() {
		return generalDropdown_second().getShadowRoot().findElement(By.cssSelector("#dropdown")).getShadowRoot()
				.findElement(By.cssSelector("#input")).getShadowRoot()
				.findElement(By.cssSelector("#labelAndInputContainer"));
	}

	public WebElement RelationshipMaindropdown_Obj() {
		return generalDropdown_First().getShadowRoot().findElement(By.cssSelector("#relationshipButton"))
				.getShadowRoot().findElement(By.cssSelector("#simpleButton"));
	}

	public WebElement HasImagesDropdownvalue() {
		return generalDropdown_First().getShadowRoot().findElement(By.cssSelector("#relationshipModelLov"))
				.getShadowRoot()
				.findElement(By.cssSelector(
						"div.base-grid-structure.p-relative > div.base-grid-structure-child-2.overflow-auto.p-relative > pebble-grid"))
				.getShadowRoot().findElement(By.cssSelector("#grid")).getShadowRoot()
				.findElement(By.cssSelector("#lit-grid"))
				.findElement(By.cssSelector("[ref='centerContainer'] > [ref='eViewport'] > [ref='eContainer']"))
				.findElement(By.cssSelector("[row-index='1']"));
	}

	public WebElement Apply_btn_onFilter() {
		return generalDropdown_First().getShadowRoot().findElement(By.cssSelector("#confirmButton")).getShadowRoot()
				.findElement(By.cssSelector("#simpleButton"));
	}

	public WebElement Save_2d_Line_Drawring() {
		return common_element().getShadowRoot().findElement(By.cssSelector("#rockTabs")).getShadowRoot()
				.findElement(By.cssSelector("[id^='rock-wizard-manage-component-rs']")).getShadowRoot()
				.findElement(By.cssSelector("[id^='rock-attribute-split-screen-component-rs']")).getShadowRoot()
				.findElement(By.cssSelector("#undefined-attribute-container > rock-attribute-manage")).getShadowRoot()
				.findElement(By.cssSelector("#next")).getShadowRoot()
				.findElement(By.cssSelector("#simpleButton"));
	}

	public WebElement Next_btn() {
		return common_element().getShadowRoot().findElement(By.cssSelector("#rockTabs")).getShadowRoot()
				.findElement(By.cssSelector("[id^='rock-wizard-manage-component-rs']")).getShadowRoot()
				.findElement(By.cssSelector("#next"));
	}

	public WebElement MoreActions_Dropdown_1() {
		return common_element().getShadowRoot().findElement(By.cssSelector("#rockTabs")).getShadowRoot()
				.findElement(By.cssSelector("[id^='rock-wizard-manage-component-rs']")).getShadowRoot()
				.findElement(By.cssSelector("[id^='rock-relationship-split-screen-component-rs']")).getShadowRoot()
				.findElement(By.cssSelector("#undefined-relationship-container > rock-relationship-manage")).getShadowRoot()
				.findElement(By.cssSelector("#entityRelationshipSearchResult_hasimages")).getShadowRoot()
				.findElement(By.cssSelector("div > div.base-grid-structure-child-2 > rock-relationship-grid")).getShadowRoot()
				.findElement(By.cssSelector("#relationship_actions"));
	}

	public WebElement MoreActions_Dropdown_2() {
		return MoreActions_Dropdown_1().getShadowRoot().findElement(By.cssSelector("#actions")).getShadowRoot()
				.findElement(By.cssSelector("#buttonTextBox"));
	}

	public WebElement AddImage_dropdownValue() {
		return MoreActions_Dropdown_1().getShadowRoot().findElement(By.cssSelector("#pebbleActionDropdown"))
				.getShadowRoot().findElement(By.cssSelector("#actionItem"));
	}

	public WebElement common_elementon_searchImage() {
		return driver.findElement(By.cssSelector("#app")).getShadowRoot()
				.findElement(By.cssSelector("[id^='rs']")).getShadowRoot()
				.findElement(By.cssSelector("#contextDialog")).getShadowRoot()
				.findElement(By.cssSelector("#rockWizardManage"));
	}
	
	public WebElement Search_Images_input() {
		return common_elementon_searchImage().getShadowRoot()
				.findElement(By.cssSelector("[id^='rock-relationship-add-component-rs']")).getShadowRoot()
				.findElement(By.cssSelector("#searchBar")).getShadowRoot().findElement(By.cssSelector("#input"));
	}
	public WebElement Totalsearch_Result() {
		return common_elementon_searchImage().getShadowRoot()
				.findElement(By.cssSelector("[id^='rock-relationship-add-component-rs']")).getShadowRoot()
				.findElement(By.cssSelector("#relatedEntitySearchGrid")).getShadowRoot()
				.findElement(By.cssSelector("#entityGrid")).getShadowRoot()
				.findElement(By.cssSelector("#gridHeader > div.grid-actions.row > span.text-ellipsis.m-r-5.m-l-5.page-range"));
	}
	
	public WebElement First_Image_checkbox() {
		return common_elementon_searchImage().getShadowRoot()
				.findElement(By.cssSelector("[id^='rock-relationship-add-component-rs']")).getShadowRoot()
				.findElement(By.cssSelector("#relatedEntitySearchGrid")).getShadowRoot()
				.findElement(By.cssSelector("#entityGrid")).getShadowRoot()
				.findElement(By.cssSelector("#gridTileView")).getShadowRoot()
				.findElement(By.cssSelector("#gridItem1 > div > div.photocontent-header > pebble-checkbox")).getShadowRoot()
				.findElement(By.cssSelector("#checkboxContainer"));
	}
	
	public WebElement Save_btn_Add_Image() {
		return common_elementon_searchImage().getShadowRoot()
	    .findElement(By.cssSelector("[id^='rock-relationship-add-component-rs']")).getShadowRoot()
	    .findElement(By.cssSelector("#next")).getShadowRoot()
	    .findElement(By.cssSelector("#buttonTextBox"));
	}
	public WebElement txt_Images_Selected() {
		return common_element().getShadowRoot()
			    .findElement(By.cssSelector("#rockTabs")).getShadowRoot()
			    .findElement(By.cssSelector("[id^='rock-wizard-manage-component-rs']")).getShadowRoot()
			    .findElement(By.cssSelector("[id^='rock-relationship-split-screen-component-rs']")).getShadowRoot()
			    .findElement(By.cssSelector("#undefined-relationship-container > rock-relationship-manage")).getShadowRoot()
			    .findElement(By.cssSelector("#entityRelationshipSearchResult_hasimages")).getShadowRoot()
			    .findElement(By.cssSelector("div > div.base-grid-structure-child-2 > rock-relationship-grid")).getShadowRoot()
			    .findElement(By.cssSelector("#bedrock_grid_hasimages")).getShadowRoot()
			    .findElement(By.cssSelector("#gridHeader > div > span.text-ellipsis.m-r-5.m-l-5.page-range"));
	}
	
	public WebElement Close_2d_lineDrawingtab() {
		return common_element().getShadowRoot()
	    .findElement(By.cssSelector("#rockTabs")).getShadowRoot()
	    .findElement(By.cssSelector("#tab-review2dlinedrawingbc_businessCondition > div > div.tab-title > span.dynamic-close"));
	}
	
	public WebElement SummaryTab() {
		return common_element().getShadowRoot()
				.findElement(By.cssSelector("#rockTabs")).getShadowRoot()
				.findElement(By.cssSelector("#tab-summary > div > div.tab-title > span"));
	}
	
	public WebElement Summarythingsneedtofix_grid() {
		return driver.findElement(By.cssSelector("#app")).getShadowRoot()
				.findElement(By.cssSelector("#contentViewManager")).getShadowRoot()
				.findElement(By.cssSelector("[id^='currentApp_entity-manage_rs']")).getShadowRoot()
				.findElement(By.cssSelector("[id^='app-entity-manage-component-rs']")).getShadowRoot()
				.findElement(By.cssSelector("#rockDetailTabs")).getShadowRoot()
				.findElement(By.cssSelector("#rockTabs")).getShadowRoot()
				.findElement(By.cssSelector("[id^='rock-entity-summary-component-rs']")).getShadowRoot()
				.findElement(By.cssSelector("[id^='rs']")).getShadowRoot()
				.findElement(By.cssSelector("#rock-entity-tofix")).getShadowRoot()
				.findElement(By.cssSelector("[id^='rock-entity-tofix-component-rs']")).getShadowRoot()
				.findElement(By.cssSelector("#accordion\\ 0 > div"));
	}

	public WebElement common_ele_2dlinedrawingDropdown() {
		return driver.findElement(By.cssSelector("#app"))
				.getShadowRoot().findElement(By.cssSelector("#contentViewManager"))
				.getShadowRoot().findElement(By.cssSelector("[id^='currentApp_entity-manage_rs']"))
				.getShadowRoot().findElement(By.cssSelector("[id^='app-entity-manage-component-rs']"))
				.getShadowRoot().findElement(By.cssSelector("#rockDetailTabs"))
				.getShadowRoot().findElement(By.cssSelector("#rockTabs"))
				.getShadowRoot().findElement(By.cssSelector("[id^='rock-wizard-manage-component-rs']"))
				.getShadowRoot().findElement(By.cssSelector("[id^='rock-attribute-split-screen-component-rs']"))
				.getShadowRoot().findElement(By.cssSelector("#undefined-attribute-container > rock-attribute-manage"))
				.getShadowRoot().findElement(By.cssSelector("#rock-attribute-list-container > rock-attribute-list"))
				.getShadowRoot().findElement(By.cssSelector("[id^='rs']"))
				.getShadowRoot().findElement(By.cssSelector("#input"))
				.getShadowRoot().findElement(By.cssSelector("bedrock-lov"));
	}

	
	public WebElement primary_Image_Required_dropdown_obj() {
		return common_element().getShadowRoot()
			    .findElement(By.cssSelector("#rockTabs")).getShadowRoot()
			    .findElement(By.cssSelector("[id^='rock-wizard-manage-component-rs']")).getShadowRoot()
			    .findElement(By.cssSelector("[id^='rock-attribute-split-screen-component-rs']")).getShadowRoot()
			    .findElement(By.cssSelector("#undefined-attribute-container > rock-attribute-manage")).getShadowRoot()
			    .findElement(By.cssSelector("#rock-attribute-list-container > rock-attribute-list")).getShadowRoot()
			    .findElements(By.cssSelector("[id^='rs']")).get(2).getShadowRoot()
			    .findElement(By.cssSelector(".attribute-edit > #input")).getShadowRoot()
			    .findElement(By.cssSelector(".attribute-control")).getShadowRoot()
			    .findElement(By.cssSelector("#collectionContainer")).getShadowRoot()
			    .findElement(By.cssSelector(".d-flex"));
	}
	
	public WebElement ImageRequired_Yes() {
		return common_element().getShadowRoot()
			    .findElement(By.cssSelector("#rockTabs")).getShadowRoot()
			    .findElement(By.cssSelector("[id^='rock-wizard-manage-component-rs']")).getShadowRoot()
			    .findElement(By.cssSelector("[id^='rock-attribute-split-screen-component-rs']")).getShadowRoot()
			    .findElement(By.cssSelector("#undefined-attribute-container > rock-attribute-manage")).getShadowRoot()
			    .findElement(By.cssSelector("#rock-attribute-list-container > rock-attribute-list")).getShadowRoot()
			    .findElements(By.cssSelector("[id^='rs']")).get(2).getShadowRoot()
			    .findElement(By.cssSelector("#input")).getShadowRoot()
			    .findElement(By.cssSelector("bedrock-lov")).getShadowRoot()
			    .findElement(By.cssSelector("#lov")).getShadowRoot()
			    .findElement(By.cssSelector("div.base-grid-structure.p-relative > div.base-grid-structure-child-2.overflow-auto.p-relative > pebble-grid")).getShadowRoot()
			    .findElement(By.cssSelector("#grid")).getShadowRoot()
			    .findElement(By.cssSelector("#lit-grid"))
			    .findElement(By.cssSelector("[ref='eRootWrapper']"))
			    .findElement(By.cssSelector("[ref='gridBody']"))
			    .findElement(By.cssSelector("[ref='eBodyViewport']"))
			    .findElement(By.cssSelector("[ref='centerContainer']"))
			    .findElement(By.cssSelector("[ref='eContainer']"))
			    .findElement(By.cssSelector("[row-index='1']"));
	}
	public WebElement ImageRequired_No() {
		return common_element().getShadowRoot()
				.findElement(By.cssSelector("#rockTabs")).getShadowRoot()
				.findElement(By.cssSelector("[id^='rock-wizard-manage-component-rs']")).getShadowRoot()
				.findElement(By.cssSelector("[id^='rock-attribute-split-screen-component-rs']")).getShadowRoot()
				.findElement(By.cssSelector("#undefined-attribute-container > rock-attribute-manage")).getShadowRoot()
				.findElement(By.cssSelector("#rock-attribute-list-container > rock-attribute-list")).getShadowRoot()
				.findElements(By.cssSelector("[id^='rs']")).get(2).getShadowRoot()
				.findElement(By.cssSelector("#input")).getShadowRoot()
				.findElement(By.cssSelector("bedrock-lov")).getShadowRoot()
				.findElement(By.cssSelector("#lov")).getShadowRoot()
				.findElement(By.cssSelector("div.base-grid-structure.p-relative > div.base-grid-structure-child-2.overflow-auto.p-relative > pebble-grid")).getShadowRoot()
				.findElement(By.cssSelector("#grid")).getShadowRoot()
				.findElement(By.cssSelector("#lit-grid"))
				.findElement(By.cssSelector("[ref='eRootWrapper']"))
				.findElement(By.cssSelector("[ref='gridBody']"))
				.findElement(By.cssSelector("[ref='eBodyViewport']"))
				.findElement(By.cssSelector("[ref='centerContainer']"))
				.findElement(By.cssSelector("[ref='eContainer']"))
				.findElement(By.cssSelector("[row-index='0']"));
	}
	
	public WebElement ApprovePrimaryImagedropdown_commonobj() {
		return common_element().getShadowRoot()
			    .findElement(By.cssSelector("#rockTabs")).getShadowRoot()
			    .findElement(By.cssSelector("[id^='rock-wizard-manage-component-rs']")).getShadowRoot()
			    .findElement(By.cssSelector("[id^='rock-attribute-split-screen-component-rs']")).getShadowRoot()
			    .findElement(By.cssSelector("#undefined-attribute-container > rock-attribute-manage")).getShadowRoot()
			    .findElement(By.cssSelector("#rock-attribute-list-container > rock-attribute-list")).getShadowRoot()
			    .findElements(By.cssSelector("[id^='rs']")).get(3);
	}
	
	public WebElement ApprovePrimaryImagedropdown_obj() {
		return ApprovePrimaryImagedropdown_commonobj().getShadowRoot()
	    .findElement(By.cssSelector("#input")).getShadowRoot()
	    .findElement(By.cssSelector("bedrock-lov")).getShadowRoot()
	    .findElement(By.cssSelector("#collectionContainer")).getShadowRoot()
	    .findElement(By.cssSelector("#collection_container_wrapper > div.d-flex > div.tags-container"));
	}
	public WebElement Approve_Primary_Image_dropdownvalue() {
		return ApprovePrimaryImagedropdown_commonobj().getShadowRoot()
	    .findElement(By.cssSelector("#input")).getShadowRoot()
	    .findElement(By.cssSelector("bedrock-lov")).getShadowRoot()
	    .findElement(By.cssSelector("#lov")).getShadowRoot()
	    .findElement(By.cssSelector("div.base-grid-structure.p-relative > div.base-grid-structure-child-2.overflow-auto.p-relative > pebble-grid")).getShadowRoot()
	    .findElement(By.cssSelector("#grid")).getShadowRoot()
	    .findElement(By.cssSelector("#lit-grid > div > div.ag-root-wrapper-body.ag-layout-normal.ag-focus-managed > div.ag-root.ag-unselectable.ag-layout-normal > div.ag-body-viewport.ag-layout-normal.ag-row-no-animation > div.ag-center-cols-clipper > div > div > div > div > pebble-lov-item"));
	}
	
	public WebElement AddPrimaryImage_Save_btn() {
		return common_element().getShadowRoot()
	    .findElement(By.cssSelector("#rockTabs")).getShadowRoot()
	    .findElement(By.cssSelector("[id^='rock-wizard-manage-component-rs']")).getShadowRoot()
	    .findElement(By.cssSelector("[id^='rock-attribute-split-screen-component-rs']")).getShadowRoot()
	    .findElement(By.cssSelector("#undefined-attribute-container > rock-attribute-manage")).getShadowRoot()
	    .findElement(By.cssSelector("#next")).getShadowRoot()
	    .findElement(By.cssSelector("#buttonTextBox"));
	}
	
	public WebElement Back_btn() {
		return common_element().getShadowRoot()
	    .findElement(By.cssSelector("#rockTabs")).getShadowRoot()
	    .findElement(By.cssSelector("[id^='rock-wizard-manage-component-rs']")).getShadowRoot()
	    .findElement(By.cssSelector("#back")).getShadowRoot()
	    .findElement(By.cssSelector("#simpleButton"));

	}
}



