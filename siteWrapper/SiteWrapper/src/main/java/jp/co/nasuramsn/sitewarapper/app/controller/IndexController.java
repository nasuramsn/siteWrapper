package jp.co.nasuramsn.sitewarapper.app.controller;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.support.WebContentGenerator;

import jp.co.nasuramsn.sitewarapper.app.form.ContentsForm;
import jp.co.nasuramsn.sitewarapper.app.utils.HtmlUtils;

@Controller
public class IndexController extends WebContentGenerator {

	@Autowired
	MessageSource messageSource;

	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		String strWrk = messageSource.getMessage("welcome", null, Locale.JAPANESE);
		System.out.println(strWrk);

		// output beans
		WebApplicationContext wac = (WebApplicationContext) getApplicationContext();
		String beanNames[] = wac.getBeanDefinitionNames();
		for (String beanName: beanNames) {
			System.out.println(beanName);
		}
		return "home";
	}

	@RequestMapping(value = { "/yahoo"}, method = RequestMethod.GET)
	public String productsPage(ModelMap model,
			ContentsForm form) {
		String htmlSource = HtmlUtils.getHtmlSource("https://www.yahoo.co.jp/");
		form.setHtmlSource(htmlSource);
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
