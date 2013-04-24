package com.aripd.account.controller;

import java.security.Principal;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aripd.account.domain.Account;
import com.aripd.account.service.AccountService;
import com.aripd.account.service.RoleService;
import com.aripd.account.web.form.ImageForm;

@PreAuthorize("isFullyAuthenticated()")
@Controller
@RequestMapping("/profile")
public class ProfileController {
	
	protected static Logger logger = Logger.getLogger(ProfileController.class);
	
	@Resource(name="accountService")
	private AccountService accountService;
	
	@Resource(name="roleService")
	private RoleService roleService;
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String showAction(Model model) {
		logger.debug("Received request to show add new record");
		model.addAttribute(new ImageForm());
		model.addAttribute("profileAttribute", accountService.findCurrentUser());
		return "profile/show";
	}

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editAction(Principal principal, Model model) {
		Account account = accountService.findOneByUsername(principal.getName());
		
		logger.debug("Received request to show edit existing record");
    	model.addAttribute("profileAttribute", account);
    	return "profile/form";
	}

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveAction(
    		Principal principal,
    		@ModelAttribute("profileAttribute") @Valid Account account, 
    		BindingResult result) {
		if (result.hasErrors()) {
			logger.error(result);
			return "/profile/form";
		}
		
		Account acc = accountService.findOneByUsername(principal.getName());
		
		account.setId(acc.getId());
		account.getCustomer().setId(acc.getCustomer().getId());
		
		logger.debug("Received request to save existing record");
		accountService.save(account);
		return "redirect:/profile/show";
	}
	
}
