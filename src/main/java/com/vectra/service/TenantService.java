package com.vectra.service;

import java.util.List;

import com.vectra.model.Tenant;

public interface TenantService {

	Tenant findById(Integer id);

	void saveTenant(Tenant tenant);

	void updateTenant(Tenant tenant);

	void deleteTenantById(Integer id);

	List<Tenant> findAllTenants();

}
