package jp.co.nasuramsn.sitewarapper.app.form;

import java.io.Serializable;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

//Login用のForm
public class LoginForm implements Serializable {

	private static final long serialVersionUID = 1L;
	@NotEmpty
	@Size(min = 1, max = 20)
	@Pattern(regexp = "[a-zA-Z0-9]*")
	private String userId = "";

	@NotEmpty
	@Size(min = 1, max = 20)
	@Pattern(regexp = "[a-zA-Z0-9]*")
	private String password = "";

	private Boolean checked = false;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}


}
