package com.vectra.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vectra.model.Tenant;
import com.vectra.service.TenantService;

@Controller
@RequestMapping("/")
public class AppController {

	@Autowired
	TenantService service;

	@Autowired
	MessageSource messageSource;

	/*
	 * This method will list all existing tenants.
	 */
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listTenants(ModelMap model) {

		List<Tenant> tenants = service.findAllTenants();
		model.addAttribute("tenants", tenants);
		return "alltenants";
	}

	/*
	 * This method will provide the medium to add a new tenant.
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newTenant(ModelMap model) {
		Tenant tenant = new Tenant();
		model.addAttribute("tenant", tenant);
		model.addAttribute("edit", false);
		return "registration";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving tenant in database. It also validates the user input
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveTenant(@Valid Tenant tenant, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "registration";
		}

		service.saveTenant(tenant);

		model.addAttribute("success", "Tenant " + tenant.getFirstName() + " registered successfully");
		return "success";
	}

	/*
	 * This method will provide the medium to update an existing tenant.
	 */
	@RequestMapping(value = { "/edit-{id}-tenant" }, method = RequestMethod.GET)
	public String editTenant(@PathVariable Integer id, ModelMap model) {
		Tenant tenant = service.findById(id);
		model.addAttribute("tenant", tenant);
		model.addAttribute("edit", true);
		return "registration";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * updating tenant in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit-{id}-tenant" }, method = RequestMethod.POST)
	public String updateTenant(@Valid Tenant tenant, BindingResult result, ModelMap model, @PathVariable Integer id) {

		if (result.hasErrors()) {
			return "registration";
		}

		service.updateTenant(tenant);

		model.addAttribute("success", "Tenant " + tenant.getFirstName() + " updated successfully");
		return "success";
	}

	/*
	 * This method will delete an tenant by it's ID value.
	 */
	@RequestMapping(value = { "/delete-{id}-tenant" }, method = RequestMethod.GET)
	public String deleteTenant(@PathVariable Integer id) {
		service.deleteTenantById(id);
		return "redirect:/list";
	}

}
