package com.epam.webapp.dao.trainingProgramImpl;

import com.epam.webapp.entity.TrainingProgram;
import com.epam.webapp.exception.DaoException;

import java.util.Optional;

public interface TrainingProgramDao {
    Optional<TrainingProgram> getUserTrainingProgram(Long userId) throws DaoException;
    void update(String value , Long id);
}