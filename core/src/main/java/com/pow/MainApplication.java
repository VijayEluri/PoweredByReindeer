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
package com.pow;

import java.util.ResourceBundle;
import java.util.ServiceLoader;

import com.vaadin.Application;
import com.pow.ui.MainWindow;
import com.pow.ui.MainWindowImpl;
import com.pow.ui.user.LoginForm.LoggedinEvent;
import com.pow.ui.user.LoginForm.LoggedinListener;
import com.pow.ui.user.function.AdminFunction;
import com.pow.ui.user.function.Functions;
import com.pow.ui.user.function.LoginFunction;
import com.pow.ui.user.function.LogoutFunction;

public class MainApplication extends Application implements LoggedinListener {

	private static final long serialVersionUID = 1L;

	private MainWindowImpl mainWindow;
	
	private Functions userFunctions;
	
	/**
	 * Sadly it is difficult, if not impossible to use Springs i18n support. 
	 * Many of the messagesources are not serializable and certainly not the
	 * application context (which usually comes with the message source if you
	 * use MessageSourceAware beans.
	 */
	private ResourceBundle i18n;
	
	@Override
	public void init() {
		userFunctions = new Functions();
		userFunctions.addFunction(new LoginFunction());
		userFunctions.addFunction(new LogoutFunction());
		userFunctions.addFunction(new AdminFunction());
		
		i18n = ResourceBundle.getBundle("com.pow.i18n.PowBundle", getLocale());
		
//		ServiceLoader<MainWindow> mainWindows = ServiceLoader.load(MainWindow.class);
//		for(MainWindow mainWindow : mainWindows) {
//			setMainWindow(mainWindow.getMainWindow());
//			break;
//		}
		mainWindow = new MainWindowImpl(this);
		setMainWindow(mainWindow);
	}

	@Override
	public void loggedin(LoggedinEvent event) {
		setUser(event.getUser());
		mainWindow.loggedin(event);
	}

	public String getMessage(String key) {
		return i18n.getString(key);
	}
	
	public Functions getUserFunctions() {
		return userFunctions;
	}

}
