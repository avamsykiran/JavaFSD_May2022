package in.tp.is.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.tp.is.entity.Txn;
import in.tp.is.exceptions.InvalidTxnException;
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
	
	@GetMapping("/delete")
	public String doDelete(@RequestParam("id") long txnId) throws OperationFailedException {
		txnService.deleteById(txnId);
		return "redirect:/txns/list";
	}
	
	@GetMapping("/save")
	public ModelAndView showTxnForm() {
		return new ModelAndView("txns/form-page", "txn", new Txn());
	}

	@PostMapping("/save")
	public ModelAndView doSave(@ModelAttribute("txn") @Valid Txn txn,BindingResult bindingResult)
			throws InvalidTxnException, OperationFailedException {
		ModelAndView mv=null;
		
		if(bindingResult.hasErrors()) {
			mv =new ModelAndView("txns/form-page", "txn", txn);
		}else {
			txnService.add(txn);
			mv = new ModelAndView("redirect:/txns/list");
		}
		
		return mv;
	}
	
	@GetMapping("/edit")
	public ModelAndView showTxnFormForEdit(@RequestParam("id") Long txnId) throws OperationFailedException {
		return new ModelAndView("txns/form-page", "txn", txnService.getById(txnId));
	}
	
	@PostMapping("/edit")
	public ModelAndView doSaveAfterEdit(@ModelAttribute("txn") @Valid Txn txn,BindingResult bindingResult)
			throws InvalidTxnException, OperationFailedException {
		ModelAndView mv=null;
		
		if(bindingResult.hasErrors()) {
			mv =new ModelAndView("txns/form-page", "txn", txn);
		}else {
			txnService.save(txn);
			mv = new ModelAndView("redirect:/txns/list");
		}
		
		return mv;
	}
}
