package org.slsale.pojo;

import java.util.List;
//菜单
public class Menu {
	//主菜单     Function功能表
	private Function mainMenu;
	//子菜单
	private List<Function> subMenus;
	public Function getMainMenu() {
		return mainMenu;
	}
	public void setMainMenu(Function mainMenu) {
		this.mainMenu = mainMenu;
	}
	public List<Function> getSubMenus() {
		return subMenus;
	}
	public void setSubMenus(List<Function> subMenus) {
		this.subMenus = subMenus;
	}
	
}
