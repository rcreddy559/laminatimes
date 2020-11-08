package com.lamina.stock;

import com.lamina.stock.dao.StockDao;
import com.lamina.stock.dao.StockDaoImpl;
import com.lamina.stock.service.StockService;
import com.lamina.stock.util.StockUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@SpringBootApplication
public class StockMarketServiceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(StockMarketServiceApplication.class, args);
    }

    @Autowired
    StockService service;


    @Override
    public void run(String... args) throws Exception {
        //StockUtil.readDefaultData(service);
    }

//    @Bean
//    public LocalSessionFactoryBean sessionFactory1() {
//        return new LocalSessionFactoryBean();
//    }

//    @Bean
//    public StockDao getStockDaoImpl() {
//        StockDao dao = new StockDaoImpl();
//        return dao;
//    }


//    @Bean
//    public HibernateTemplate setBean() {
//        HibernateTemplate hibernateTemplate = new HibernateTemplate();
//        hibernateTemplate.setSessionFactory((SessionFactory) new HibernateConfiguration().sessionFactory());
//        return new HibernateTemplate();
//    }

}
