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
package com.pow.i18n;

import java.io.Serializable;
import java.util.ListResourceBundle;

public class PowBundle_nl extends ListResourceBundle implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected Object[][] getContents() {
		return contents;
	}
	
    static final Object[][] contents = {
    	{"MainWindow.title","Vaadin-Engine, Vaadin en Google AppEngine, zo eenvoudig kan het zijn"},
    	{"MainWindow.loggedin", "Je bent succesvol ingelogged."},
    	
    	{"LoginFunction.caption", "Inloggen"},
    	{"LogoutFunction.caption", "Uitloggen"},
    	{"AdminFunction.caption", "Sample admin function"},
    	
    	{"LoginWindow.caption", "Inloggen"},
    	{"LoginFormFieldFactory.email", "E-mail"},
    	{"LoginFormFieldFactory.password", "Password"},
    	{"LoginForm.loginButton.caption", "Inloggen"},
    	{"LoginForm.description", "Voer hier het e-mail adres en wachtwoord in waarmee u zich geregistreerd heeft. " +
				"Indien u nog niet geregistreerd bent, click dan op registreren om u voor het eerst aan te melden." },
		{"LoginForm.BadCredentialsException", "Uw gebruikersnaam en/of wachtwoord zijn niet correct."},
    };
    
}
