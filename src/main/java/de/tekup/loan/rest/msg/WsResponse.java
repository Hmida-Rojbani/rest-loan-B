package de.tekup.loan.rest.msg;

import java.util.List;

import lombok.Data;

@Data
public class WsResponse {

	private boolean isEligeble;
	private long approvedAmount;
	private List<String> criteriaMismatch;
}
