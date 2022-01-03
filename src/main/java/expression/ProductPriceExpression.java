package expression;

import com.mysema.query.annotations.QueryDelegate;
import com.mysema.query.types.expr.BooleanExpression;
import domain.Product;
import domain.QProduct;

public class ProductPriceExpression {

    @QueryDelegate(Product.class)
    public static BooleanExpression isExpensive(QProduct product, int price){
        return product.price.gt(price);
    }
}
