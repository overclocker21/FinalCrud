package com.vectra.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.vectra.model.Tenant;

@Repository("tenantDao")
public class TenantDaoImpl extends AbstractDao<Integer, Tenant> implements TenantDao {

	@Override
	public Tenant findById(Integer id) {
		return getByKey(id);
	}

	@Override
	public void saveTenant(Tenant tenant) {
		persist(tenant);
	}

	@Override
	public void deleteTenantById(Integer id) {
		Query query = getSession().createSQLQuery("delete from tenant where id = :id");
		query.setInteger("id", id);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tenant> findAllTenants() {
		Criteria criteria = createEntityCriteria();
		return (List<Tenant>) criteria.list();
	}

}
