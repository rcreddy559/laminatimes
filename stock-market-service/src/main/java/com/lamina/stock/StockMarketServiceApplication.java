package com.lamina.stock;

import com.lamina.stock.dao.StockDao;
import com.lamina.stock.dao.StockDaoImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@SpringBootApplication
public class StockMarketServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockMarketServiceApplication.class, args);
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
