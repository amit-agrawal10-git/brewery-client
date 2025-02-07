package spring.micro.breweryclient.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {
    private UUID id;
    private Integer version, quantityOnHand;
    private OffsetDateTime createdDate, lastModifiedDate;
    private String beerName;
    private BeerStyleEnum beerStyle;
    private BigDecimal price;
    private Long upc;

}
