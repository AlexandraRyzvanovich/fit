package com.epam.webapp.command.client;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class GetExercisesList implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request) throws ServiceException, SQLException, IOException {
        return null;
    }
}