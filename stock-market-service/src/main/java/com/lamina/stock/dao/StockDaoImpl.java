package com.lamina.stock.dao;

import com.lamina.stock.beans.Stock;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StockDaoImpl implements StockDao {
    static final Logger logger = LoggerFactory.getLogger(StockDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Stock> getAllStock() {
        Session session = this.sessionFactory.getCurrentSession();
        logger.info("getAllStock:: session.getTransaction().getStatus().name(): {}", session.getTransaction().getStatus().name());
        return (List<Stock>) session.createQuery("from Stock ").list();
    }

    @Override
    public List<Stock> getAllStockByUserId(long userId) {
        return null;
    }

    @Override
    public Long addStock(Stock stock) {
        Session session = this.sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Long id = (Long) session.save(stock);
        transaction.commit();
        return id;
    }

    @Override
    public void updateStock(Stock stock) {

    }

    @Override
    public void deleteStock(Stock stock) {

    }

    @Override
    public List<Stock> getByUserId(long userId) {
        Session session = this.sessionFactory.getCurrentSession();
        Query<Stock> query = session.createQuery("from Stock where userId=:userId");
        query.setParameter("userId", userId);

        return query.list();
    }

    @Override
    public Stock getStock(long id) {
        return this.sessionFactory.getCurrentSession().get(Stock.class, id);
    }

    @Override
    public List<Long> addAll(List<Stock> stockResponses) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Long> ids = stockResponses.stream().map(stock -> (Long) session.save(stock)).collect(Collectors.toList());
        session.getTransaction().commit();
        return ids;
    }
}
