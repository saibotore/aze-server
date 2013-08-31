package de.tgehring.aze.server;

import de.tgehring.aze.server.service.CRUDService;

public class Main {
	
	public static void main(String[] args) {
		CRUDService.getInstance().readPerson();
	}

}
