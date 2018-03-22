package com.bank.mts.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bank.mts.service.TxrService;

@Controller
public class TxrController {

	@Autowired
	private TxrService txrService;

	@RequestMapping(value = "/txr", method = RequestMethod.POST)
	public @ResponseBody String doTxr(@ModelAttribute TxrRequest request, Model model) {
		txrService.txr(request.getAmount(), request.getFromAccNum(), request.getToAccNum());
		TxrResponse txrResponse = new TxrResponse();
		txrResponse.setStatus("Txr success");
		// model.addAttribute("status", txrResponse);
		return txrResponse.getStatus();
	}

}
