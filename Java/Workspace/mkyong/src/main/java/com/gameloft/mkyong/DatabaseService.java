package com.gameloft.mkyong;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DatabaseService {

	@Value("${db.name:hello}")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "DatabaseService [name=" + name + "]";
	}
	
	
	
}
