package in.tp.is.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import in.tp.is.exceptions.OperationFailedException;
import in.tp.is.service.TxnService;

@Controller
@RequestMapping("/txns")
public class TxnsController {
	
	@Autowired
	private TxnService txnService;
	
	@GetMapping("/list")
	public ModelAndView showTxns() throws OperationFailedException {
		return new ModelAndView("txns/list-page","txns",txnService.getAll());
	}
}
