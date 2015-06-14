package com.sonatype.maven.weather.yahoo;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

public final class ProxyAuthenticator extends Authenticator {
	private String user, password;  
	  
    public ProxyAuthenticator(String user, String password) {  
        this.user = user;  
        this.password = password;  
    }  
  
    protected PasswordAuthentication getPasswordAuthentication() {  
        return new PasswordAuthentication(user, password.toCharArray());  
    }  
}
