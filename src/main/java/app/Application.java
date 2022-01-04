package app;

import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import domain.QProduct;
import util.SearchParam;
import domain.Product;
import dto.ProductListDto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static domain.QProduct.product;

public class Application {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test-project");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

//        selectAll(new JPAQueryFactory(em)).forEach(p -> System.out.println(p.toString()));
//        paging(new JPAQueryFactory(em));
        update(new JPAQueryFactory(em));
//        tupleTest(initQuery(em));
//        update(em);
//        selectUpdated(initQuery(em));
//        booleanBuilder(initQuery(em));
//        methodDelegation(initQuery(em));
//        bulkPriceUpdate(em);
//        em.getTransaction().commit();
//        selectAll(initQuery(em)).forEach(p-> System.out.println(p.toString()));
//        bulkPriceUpdate(em);
//        products.forEach(em::refresh);

//        em.getTransaction().commit();

        System.exit(-1);

    }
    public static List<Product> selectAll(JPAQueryFactory queryFactory){

        queryFactory.select(product).from(product).where(product.price.gt(5000).and(product.stockAmount.gt(15)));
        return queryFactory.selectFrom(product).where(product.price.gt(10000)).fetch();
    }

    public static void paging(JPAQueryFactory queryFactory){

        QueryResults<Product> results =
                queryFactory.selectFrom(product)
                .limit(5L)
                .orderBy(product.price.desc())
                .fetchResults();
        System.out.println(results.getTotal());
//        SearchResults<Product> results =
//                query.from(product)
//                .limit(5L)
//                .orderBy(product.price.asc())
//                .listResults(product);

        results.getResults().forEach((p -> System.out.println(p.toString())));
    }
//
//    public static void tupleTest(JPAQuery query){
//        List<Tuple> results =
//                query.from(product)
//                .where(product.price.gt(17000))
//                    .list(product.name,product.stockAmount, product.price);
//
//            results.forEach(t -> {
//                System.out.println(Arrays.toString(t.toArray()));
//        });
//
//        List<ProductListDto> list =  results.stream().map(ProductListDto::new).collect(Collectors.toList());
//        list.forEach(dto -> System.out.println(dto.toString()));
//    }
//
    public static void update(JPAQueryFactory queryFactory){

        long count = queryFactory.update(product).set(product.price, product.price.add(3000)).execute();


//        JPAUpdateClause updateClause = new JPAUpdateClause(em, product);
//
//        long count = updateClause.where(product.name.eq("밀키트5"))
//                .set(product.price, product.price.add(3000))
//                .execute();
//
        System.out.println("executed : " + count);
    }
//
//    public static void bulkPriceUpdate(EntityManager em){
//        JPAUpdateClause updateClause = new JPAUpdateClause(em, product);
//        long count = updateClause.where(product.stockAmount.lt(15))
//                .set(product.price, product.price.multiply(2))
//                .execute();
//
//        System.out.println("updated : " + count);
//    }
//
//    public static void selectUpdated(JPAQuery query){
//
//        Product result = query.from(product)
//                .where(product.name.eq("밀키트5"))
//                .uniqueResult(product);
//
//        System.out.println(result);
//    }
//
//    public static void booleanBuilder(JPAQuery query){
//        SearchParam param = new SearchParam();
////        param.setPrice(20000);
//        param.setStockAmount(25);
//
//        BooleanBuilder builder = new BooleanBuilder();
//        if (param.getPrice()>0){
//            builder.and(product.price.gt(param.getPrice()));
//        }
//
//        List<Product> results = query.from(product)
//                .where(builder)
//                .list(product);
//
//        results.forEach(p -> System.out.println(p.toString()));
//
//    }
//
//    public static void methodDelegation(JPAQuery query){
//        List<Product> results =
//                query.from(product)
//                .where(product.isExpensive(30000))
//                .list(product);
//
//        results.forEach(r -> System.out.println(r.toString()));
//
//    }
//
//    public static JPAQuery initQuery(EntityManager em){
//        return new JPAQuery((em));
//    }

}
