package com.novmah.productservice.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = {"category"})
public class Product extends AbstractMappedEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, updatable = false)
    private Integer id;

    private String name;
    private String imageUrl;
    private String sku;
    private BigDecimal price;
    private Integer quantity;

    private Integer sellerId;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
