package jp.co.nasuramsn.sitewarapper.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.WebContentGenerator;

import jp.co.nasuramsn.sitewarapper.app.form.LoginForm;
import jp.co.nasuramsn.sitewarapper.app.service.impl.LoginServiceImpl;
import jp.co.nasuramsn.sitewarapper.common.session.SessionUserInfo;


// Login関連の処理
@Controller
public class LoginController extends WebContentGenerator {

	@Autowired
	SessionUserInfo sessionUserInfo;

	// Login画面に遷移
	@RequestMapping(value = { "/login" }, params = "login", method = RequestMethod.POST)
    String login(@ModelAttribute("loginForm") LoginForm form
    		, Model model) {
		return "login";
    }

	// Login実行
	@RequestMapping(value = { "/login" }, params = "execute", method = RequestMethod.POST)
    String execute(@Validated @ModelAttribute("loginForm") LoginForm form,
    		BindingResult result
    		, Model model) {

		if (result.hasErrors()) {
			return "login";
		} else {
			LoginServiceImpl loginService = new LoginServiceImpl();
			if (loginService.login(form)) {
				//Session変数の設定
				sessionUserInfo.setUserId(form.getUserId());
				sessionUserInfo.setUserName("Test User");
				sessionUserInfo.setUserAuthority(1);

				return "home";
			} else {
				model.addAttribute("message", "Invalued Entry!");
				return "login";
			}
		}
    }

	// Logout実行
    @RequestMapping(value = { "/login" }, params = "logout", method = RequestMethod.POST)
    String logout(ModelMap model) {
    	//Session変数の設定
		sessionUserInfo.setUserId("");
		sessionUserInfo.setUserName("");
		sessionUserInfo.setUserAuthority(0);

    	return "redirect:/";
    }
}
