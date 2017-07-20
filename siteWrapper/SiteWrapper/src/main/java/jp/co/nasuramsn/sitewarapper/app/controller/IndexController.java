package jp.co.nasuramsn.sitewarapper.app.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

	@Autowired
	MessageSource messageSource;

	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		String strWrk = messageSource.getMessage("welcome", null, Locale.JAPANESE);
		System.out.println(strWrk);

		return "home";
	}

	@RequestMapping(value = { "/yahoo"}, method = RequestMethod.GET)
	public String productsPage(ModelMap model) {
		return "products";
	}

	@RequestMapping(value = { "/google"}, method = RequestMethod.GET)
	public String contactUsPage(ModelMap model) {
		return "contactus";
	}

	@RequestMapping(value = "edit", params = "geturl", method = RequestMethod.POST)
    public String geturl() {

		System.out.println("geturl");
		return "views/index";
    }
}
