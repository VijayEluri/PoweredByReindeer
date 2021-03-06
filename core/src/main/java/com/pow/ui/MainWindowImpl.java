/*
 *    Copyright 2010 Peter Backx, streamhead.com
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *    
 *    http://www.apache.org/licenses/LICENSE-2.0
 *    
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.pow.ui;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.pow.MainApplication;
import com.pow.domain.user.User;
import com.pow.ui.user.LoginForm.LoggedinEvent;
import com.pow.ui.user.LoginForm.LoggedinListener;
import com.pow.ui.user.function.Function;

public class MainWindowImpl extends Window implements LoggedinListener, MainWindow {

	private static final long serialVersionUID = 1L;
	
	private MainApplication app;
	private HorizontalLayout userFunctionMenu = new HorizontalLayout();
	
	public MainWindowImpl(final MainApplication mainApplication) {
		super(mainApplication.getMessage("MainWindow.title"));
		this.app = mainApplication;

		addComponent(new Label("Welcome, hold on for customization instructions. If you want to try the user functionality. You can login using" +
				" any e-mail and password 'test'."));
		addComponent(userFunctionMenu);
		redrawUserFunctions();
	}

	private void redrawUserFunctions() {
		userFunctionMenu.removeAllComponents();
		for(final Function function : app.getUserFunctions().getFunctions()) {
			User user = (User)app.getUser();
			if(function.isAvailable(user)) {
				userFunctionMenu.addComponent(new Button(
						app.getMessage(function.getCaptionKey()), 
						new ClickListener() {
							private static final long serialVersionUID = 1L;
							@Override
							public void buttonClick(ClickEvent event) {
								function.launch(app);
							}
						})
				);
			}
		}
	}

	@Override
	public void loggedin(LoggedinEvent event) {
		showNotification(app.getMessage("MainWindow.loggedin"));
		redrawUserFunctions();
	}

	@Override
	public Window getMainWindow() {
		return this;
	}
}
