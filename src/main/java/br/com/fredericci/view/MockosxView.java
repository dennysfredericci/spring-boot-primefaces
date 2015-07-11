package br.com.fredericci.view;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.stereotype.Component;

@Component
public class MockosxView {

	private String text;

	public void init() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Software Update", "New version of iTunes is available"));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Software Update", "New version of PrimeFaces is available"));
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
