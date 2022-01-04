package app;

import com.querydsl.jpa.impl.JPAQueryFactory;
import domain.support.ProductQuerySupport;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProductTestApp {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test-project");
        EntityManager em = emf.createEntityManager();

        queryWithProjections(new JPAQueryFactory(em));

    }

    public static void queryWithProjections(JPAQueryFactory queryFactory){

        ProductQuerySupport querySupport = new ProductQuerySupport(queryFactory);

        Long productId = 2L;

        System.out.println(querySupport.findProductById(2L).toString());


    }

}
