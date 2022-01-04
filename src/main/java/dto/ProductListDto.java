package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductListDto {

    private String name;
    private int stockAmount;
    private int price;


//    public ProductListDto(Tuple tuple) {
//        name = tuple.get(0, String.class);
//        stockAmount = tuple.get(1, Integer.class);
//        price = tuple.get(2, Integer.class);
//    }
}
