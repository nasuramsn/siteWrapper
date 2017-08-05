package jp.co.nasuramsn.sitewarapper.app.controller;

import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.WebContentGenerator;

import jp.co.nasuramsn.sitewarapper.app.form.ContentsForm;
import jp.co.nasuramsn.sitewarapper.app.utils.HtmlUtils;

@Controller
public class IndexController extends WebContentGenerator {

	@Autowired
	MessageSource messageSource;

	private Logger logger = Logger.getLogger(IndexController.class);

	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		String strWrk = messageSource.getMessage("welcome", null, Locale.JAPANESE);
		System.out.println(strWrk);

		// output beans
		/*WebApplicationContext wac = (WebApplicationContext) getApplicationContext();
		String beanNames[] = wac.getBeanDefinitionNames();
		for (String beanName: beanNames) {
			System.out.println(beanName);
		}*/
		logger.info("homePage done!");

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
}
