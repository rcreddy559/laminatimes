package com.lamina.stock.dao;

import com.lamina.stock.beans.Stock;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StockDaoImpl implements StockDao {
    static final Logger logger = LoggerFactory.getLogger(StockDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Stock> getAllStock() {
        Session session = this.sessionFactory.getCurrentSession();
        logger.info("getAllStock:: session.getTransaction().getStatus().name(): {}",session.getTransaction().getStatus().name());
        List<Stock> stocks = (List<Stock>) session.createQuery("from Stock ").list();
        return stocks;
    }

    @Override
    public List<Stock> getAllStockByUserId(long userId) {
        return null;
    }

    @Override
    public Stock getStock(long id) {
        return null;
    }

    @Override
    public Stock addStock(Stock stock) {
        return null;
    }

    @Override
    public void updateStock(Stock stock) {

    }

    @Override
    public void deleteStock(Stock stock) {

    }

    @Override
    public List<Stock> findByUserId(long userId) {
        Session session = this.sessionFactory.getCurrentSession();
        Query<Stock> query = session.createQuery("from Stock where userId=:userId");
        query.setParameter("userId", userId);

        return query.list();
    }

    @Override
    public Stock findById(long id) {
        Session session = this.sessionFactory.getCurrentSession();

        return session.get(Stock.class, id);
    }

    @Override
    public void addAll(List<Stock> stockResponses) {
        Session session = this.sessionFactory.getCurrentSession();
        //session.beginTransaction();
        logger.info("addAll:: session.getTransaction().getStatus().name(): {}",session.getTransaction().getStatus().name());
        stockResponses.forEach(session::save);
        //session.getTransaction().commit();
    }
}
