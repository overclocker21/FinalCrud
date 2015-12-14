package com.vectra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vectra.dao.TenantDao;
import com.vectra.model.Tenant;

@Service("tenantService")
@Transactional
public class TenantServiceImpl implements TenantService {

	@Autowired
	private TenantDao dao;

	@Override
	public Tenant findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public void saveTenant(Tenant tenant) {
		dao.saveTenant(tenant);
	}

	@Override
	public void updateTenant(Tenant tenant) {
		Tenant entity = dao.findById(tenant.getId());
		if (entity != null) {
			entity.setFirstName(tenant.getFirstName());
			entity.setLastName(tenant.getLastName());
			entity.setPhone(tenant.getPhone());
			entity.setEmail(tenant.getPhone());
		}
	}

	@Override
	public void deleteTenantById(Integer id) {
		dao.deleteTenantById(id);
	}

	@Override
	public List<Tenant> findAllTenants() {
		return dao.findAllTenants();
	}

}
