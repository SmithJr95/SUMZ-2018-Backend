package edu.dhbw.ka.mwi.businesshorizon2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services.MailTestService;

@RestController
@RequestMapping("/mail")
public class MailTestController {
	@Autowired
	private MailTestService mailTestService;
	
	@RequestMapping(method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
	public void sendMail() {
		mailTestService.sendSimpleMessage("matthias.kugel@gmx.de", "Betreff", "Inhalt");
	}
}
