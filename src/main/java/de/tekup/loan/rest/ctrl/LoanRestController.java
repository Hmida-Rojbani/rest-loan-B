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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
@Api(value = "LaonEligebilty" , description = "Service to check eligeblity of client to get a loan")
public class LoanRestController {
	@Autowired
	private LoanEligebiltyService service;
	
	@ApiOperation(value = "Check customer for a loan", response = WsResponse.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfuly can get a credit")
	})
	@PostMapping(path="/get-status", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}
								, consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<WsResponse> getLoanStatus(@RequestBody CustomerRequest request){
		WsResponse response = service.checkLoanEligeblity(request);
		
		return new ResponseEntity<WsResponse>(response, HttpStatus.OK);
	}

}
