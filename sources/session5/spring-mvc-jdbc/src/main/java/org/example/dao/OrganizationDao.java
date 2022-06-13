package org.example.dao;

import org.example.domain.Organization;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.util.List;

public interface OrganizationDao {
    @Autowired
    void setDataSource(DataSource dataSource);

    boolean create(Organization organization);

    Organization getOrganization(int id);

    List<Organization> getAllOrganizations();

    void cleanup();
}
