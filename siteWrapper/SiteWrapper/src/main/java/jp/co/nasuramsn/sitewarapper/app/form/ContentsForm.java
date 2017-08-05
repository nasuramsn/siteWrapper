package jp.co.nasuramsn.sitewarapper.app.form;

import java.io.Serializable;

import javax.validation.constraints.Size;

//Contents画面用のform
public class ContentsForm implements Serializable{

	private static final long serialVersionUID = 1l;

	@Size(max = 20000)
	private String htmlSource;

	public String getHtmlSource() {
		return htmlSource;
	}

	public void setHtmlSource(String text) {
		this.htmlSource = text;
	}

}
