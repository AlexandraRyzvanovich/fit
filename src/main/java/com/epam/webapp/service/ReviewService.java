package com.epam.webapp.service;

import com.epam.webapp.dao.AbstractDao;
import com.epam.webapp.dao.DaoHelper;
import com.epam.webapp.dao.DaoHelperFactory;
import com.epam.webapp.entity.Review;
import com.epam.webapp.exception.DaoException;
import com.epam.webapp.exception.ServiceException;

import java.util.Date;
import java.util.List;

public class ReviewService {
    private DaoHelperFactory daoHelperFactory;

    public ReviewService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public List<Review> getAllReview() throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            AbstractDao<Review> dao = (AbstractDao<Review>) factory.createReviewDao();
            return dao.getAll();
        } catch ( DaoException e) {
            throw new ServiceException(e.getCause());
        }
    }

    public void addReview(Long userId, String reviewMsg, Integer star) throws ServiceException {
        Date date = new Date();
        Review review = new Review(userId, reviewMsg, star, date);
        try (DaoHelper factory = daoHelperFactory.create()) {
            AbstractDao<Review> dao = (AbstractDao<Review>) factory.createReviewDao();
            dao.save(review);
        } catch ( DaoException e) {
            throw new ServiceException(e.getCause());
        }
    }
}
