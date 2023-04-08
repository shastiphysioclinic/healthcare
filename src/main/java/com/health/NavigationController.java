package com.health;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.stereotype.Component;

@Component
@ManagedBean
@RequestScoped
public class NavigationController {
	public String navigateToPage1() {
		return "page1";
	}
	public String navigateToIndexPage() {
		return "index";
	}
}
