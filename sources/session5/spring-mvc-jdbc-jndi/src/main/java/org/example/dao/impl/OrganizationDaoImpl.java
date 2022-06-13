package org.example.dao.impl;

import org.example.dao.OrganizationDao;
import org.example.domain.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class OrganizationDaoImpl implements OrganizationDao {

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    @Override
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public boolean create(Organization organization) {
        String sqlQuery = "INSERT INTO Organization(" +
                "companyName, " +
                "yearOfIncorporation, " +
                "postalCode, " +
                "employeeCount, " +
                "slogan)" +
                " VALUES(" +
                ":companyName, " +
                ":yearOfIncorporation, " +
                ":postalCode, " +
                ":employeeCount, " +
                ":slogan)";

        SqlParameterSource params = new BeanPropertySqlParameterSource(organization);

        return jdbcTemplate.update(sqlQuery, params) == 1;
    }

    @Override
    public Organization getOrganization(int organizationId) {
        String sqlQuery = "SELECT * FROM Organization WHERE organizationId = :organizationId";

        SqlParameterSource param = new MapSqlParameterSource("organizationId", organizationId);

        return jdbcTemplate.queryForObject(sqlQuery, param, new OrganizationRowMapper());
    }

    @Override
    public List<Organization> getAllOrganizations() {
        String sqlQuery = "SELECT * FROM Organization";

        return jdbcTemplate.query(sqlQuery, new OrganizationRowMapper());
    }

    @Override
    public void cleanup() {
        String sqlQuery = "TRUNCATE TABLE Organization";

        jdbcTemplate.getJdbcOperations().execute(sqlQuery);
    }
}
