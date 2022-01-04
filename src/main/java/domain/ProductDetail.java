package domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class ProductDetail {

    private String detail;

    @Column(precision = 3, scale = 1)
    private double discountRate;

}
