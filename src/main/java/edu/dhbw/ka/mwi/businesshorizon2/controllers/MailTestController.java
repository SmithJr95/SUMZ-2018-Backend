package edu.dhbw.ka.mwi.businesshorizon2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services.MailTestService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/mail")
public class MailTestController {
	@Autowired
	private MailTestService mailTestService;
	
	@ApiOperation(value = "")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "successful operation"),
			@ApiResponse(code = 400, message = "something went wrong"),
			@ApiResponse(code = 401, message = "unauthorized")
	})
	@RequestMapping(method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
	public void sendMail() {
		mailTestService.sendSimpleMessage("matthias.kugel@gmx.de", "Betreff", "Inhalt");
	}
}
