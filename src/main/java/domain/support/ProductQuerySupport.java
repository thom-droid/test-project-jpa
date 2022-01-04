package domain.support;


import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import domain.ProductDetail;
import dto.ProductDetailDto;

import static domain.QProduct.product;

import javax.persistence.EntityManager;

public class ProductQuerySupport {

    private JPAQueryFactory jpaQueryFactory;

    public ProductQuerySupport(JPAQueryFactory queryFactory){
        this.jpaQueryFactory = queryFactory;
    }

    public ProductDetailDto findProductById(Long productId){

        return jpaQueryFactory
                .select(
                Projections.constructor
                        (
                        ProductDetailDto.class,
                        product.name.as("productName"),
                        product.price,
                        product.stockAmount.as("stock"),
                        Projections.constructor(
                                ProductDetail.class,
                                product.productDetail.detail,
                                product.productDetail.discountRate
                        )
//                        product.productDetail.detail,
//                        product.productDetail.discountRate
                        )
                )
                .from(product)
                .where(product.id.eq(productId))
                .fetchOne();

    }

}
