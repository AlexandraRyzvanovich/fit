package com.epam.webapp.dao;

import java.sql.Connection;
import java.util.Optional;

import com.epam.webapp.entity.Identifiable;
import com.epam.webapp.entity.User;
import com.epam.webapp.exception.DaoException;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {

    /**
     * Запрос поиска пользователя по логину и паролю.
     */
    private static final String FIND_BY_LOGIN_AND_PASSWORD = "SELECT * FROM user WHERE login = ? AND password = MD5(?)";

    /**
     * Запрос поиска пользователя по имени.
     */
    private static final String FIND_BY_FIRST_NAME = "SELECT * FROM user WHERE first_name = ?";

    private static final String DELETE_BY_ID = "";

    private static final String INSERT = "";

    public UserDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public Optional<User> findUserByLoginAndPassword(String login, String password) throws DaoException {
        return executeForStringResult(FIND_BY_LOGIN_AND_PASSWORD, login, password);
    }

    @Override
    public Optional<User> getById(Long id) {
        return Optional.empty(); //todo добавить реализацию
    }

    @Override
    public void save(Identifiable item) {
    }

    @Override
    public void removeById(Long id) throws DaoException{
        executeForStringResult(DELETE_BY_ID, id);
    }

    @Override
    public Optional<User> findByFirstName(String firstName) throws DaoException{
        return executeForStringResult(FIND_BY_FIRST_NAME, firstName);
    }

    protected String getTableName() {
        return User.TABLE_NAME;
    }
}
