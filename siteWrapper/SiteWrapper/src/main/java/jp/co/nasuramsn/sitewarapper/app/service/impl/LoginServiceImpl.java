package jp.co.nasuramsn.sitewarapper.app.service.impl;

import jp.co.nasuramsn.sitewarapper.app.form.LoginForm;
import jp.co.nasuramsn.sitewarapper.app.service.LoginService;

public class LoginServiceImpl implements LoginService {

	@Override
	public Boolean login(LoginForm loginForm) {

		// Loginチェック
		if (loginForm.getUserId().equals("testuser") &&
				loginForm.getPassword().equals("password")) {
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}

}
