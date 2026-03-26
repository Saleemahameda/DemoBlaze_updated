package com.PageObjectManager;

import com.PageObjectModel.AddtoCartpageElementsPOM;
import com.PageObjectModel.LoginPageElementsPOM;
import com.PageObjectModel.ProductpageElementsPOM;
import com.Utility_Demo.FileReadManager_demo;

public class PageObjectManager {
	
	private static PageObjectManager manager;   // manager = new PageObjectManager()
	private LoginPageElementsPOM login;
	private ProductpageElementsPOM product;
	private AddtoCartpageElementsPOM AddtoCart;
	private FileReadManager_demo reader;

	private PageObjectManager() {

	}

	public static PageObjectManager getPageObjectManager() {

	    if (manager == null) {
	        manager = new PageObjectManager();
	    }

	    return manager;
	}

	public LoginPageElementsPOM getLoginPageElementsPOM() {

	    if (login == null) {
	        login = new LoginPageElementsPOM();
	    }

	    return login;
	}

	public FileReadManager_demo getFileReadManager_demo() {

	    if (reader == null) {
	        reader = new FileReadManager_demo();
	    }

	    return reader;
	}

	public ProductpageElementsPOM getProductpageElementsPOM() {

	    if (product == null) {
	        product = new ProductpageElementsPOM();
	    }

	    return product;
	}
	public AddtoCartpageElementsPOM getAddtoCartpageElementsPOM() {

	    if (AddtoCart == null) {
	    	AddtoCart = new AddtoCartpageElementsPOM();
	    }

	    return AddtoCart;
	}

}
