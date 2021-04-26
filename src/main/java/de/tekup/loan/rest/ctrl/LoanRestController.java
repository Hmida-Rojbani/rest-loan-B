package de.tekup.loan.rest.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.loan.rest.msg.CustomerRequest;
import de.tekup.loan.rest.msg.WsResponse;
import de.tekup.loan.rest.service.LoanEligebiltyService;

@RestController
@RequestMapping("/api")
public class LoanRestController {
	@Autowired
	private LoanEligebiltyService service;
	
	@PostMapping(path="/get-status", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}
								, consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<WsResponse> getLoanStatus(@RequestBody CustomerRequest request){
		WsResponse response = service.checkLoanEligeblity(request);
		
		return new ResponseEntity<WsResponse>(response, HttpStatus.OK);
	}

}
