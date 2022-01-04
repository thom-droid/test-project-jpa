package dto;

import domain.ProductDetail;
import lombok.*;

@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDetailDto {

    private String productName;
    private int price;
    private int stock;

//    private String detail;
//    private double discount;

    private ProductDetail productDetail;
}
