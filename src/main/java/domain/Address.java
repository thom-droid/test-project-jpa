package domain;

import lombok.*;

import javax.persistence.Embeddable;

@EqualsAndHashCode
@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class Address {

    private String city;
    private String street;
    private String zip;

}
