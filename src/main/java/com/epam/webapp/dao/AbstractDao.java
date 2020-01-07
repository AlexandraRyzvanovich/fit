package com.epam.webapp.dao;

import com.epam.webapp.builder.RowMapper;
import com.epam.webapp.entity.Identifiable;
import com.epam.webapp.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractDao <T extends Identifiable> implements Dao {
    private Connection connection;
    protected AbstractDao(Connection connection){
        this.connection = connection;
    }
    protected List<T> executeQuery(String query, RowMapper<T> mapper, Object...params) throws DaoException {
        try(PreparedStatement statement = createStatement(query, params);
            ResultSet resultSet = statement.executeQuery(query)) {
            List<T> entities = new ArrayList<>();
            while (resultSet.next()){
                T entity = mapper.map(resultSet);
                entities.add(entity);
            }
            return entities;
        }catch (SQLException ex){
            throw new DaoException("Exception occurred while executing SQL query",ex.getCause());
        }
    }
    private PreparedStatement createStatement(String query, Object...params) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        for(int i = 1; i <= params.length; i++){
            statement.setObject(i, params[i-1]);
        }
        return statement;
    }
    public List<T> getAll() throws DaoException {
        String table = getTableName();
        RowMapper<T> mapper = (RowMapper<T>) RowMapper.create(table);
        return executeQuery("select*from" + table, mapper);
    }

    protected Optional<T> executeForStringResult(String query, RowMapper<T> mapper, Object...params) throws DaoException {
        List<T> items = executeQuery(query, mapper, params);
        if(items.size() == 1)
        {
            return Optional.of(items.get(0));
        }else if(items.size() >1){
            throw new IllegalArgumentException("More then one record found");
        }else {
            return Optional.empty();
        }
    }
    protected abstract String getTableName();
}