package com.vectra.dao;

import java.util.List;

import com.vectra.model.Tenant;

public interface TenantDao {

	Tenant findById(Integer id);

	void saveTenant(Tenant tenant);

	void deleteTenantById(Integer id);

	List<Tenant> findAllTenants();

}
