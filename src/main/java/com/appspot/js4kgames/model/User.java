package com.appspot.js4kgames.model;

import java.io.Serializable;

/**
 * Holds the data of a js4kgames user's profile.
 * 
 * @author js4kgames
 */
public class User implements Serializable {

    private static final long serialVersionUID = -7776203671377315915L;

    private String id;
	
	private String guid;
	
	private String emailAddress;
	
	private String name;
	
	private String nickName;
	
	private boolean admin;
	
	private boolean loggedIn;
	
	private String twitterUrl;
	
	private String facebookUrl;
	
	private String googlePlusUrl;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTwitterUrl() {
		return twitterUrl;
	}

	public void setTwitterUrl(String twitterUrl) {
		this.twitterUrl = twitterUrl;
	}

	public String getFacebookUrl() {
		return facebookUrl;
	}

	public void setFacebookUrl(String facebookUrl) {
		this.facebookUrl = facebookUrl;
	}

	public String getGooglePlusUrl() {
		return googlePlusUrl;
	}

	public void setGooglePlusUrl(String googlePlusUrl) {
		this.googlePlusUrl = googlePlusUrl;
	}

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}
