package com.densoft.springdatajpa.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@NamedQuery(
//        name = "Product.findByPrice",
//        query = "SELECT p from Product p WHERE p.price = :price"
//)
@NamedQueries(
        {
                @NamedQuery(
                        name = "Product.findAllOrderByNameDesc",
                        query = "SELECT p from Product p ORDER BY p.name DESC"
                ),
                @NamedQuery(
                        name = "Product.findByPrice",
                        query = "SELECT p from Product p WHERE p.price = :price"
                )
        }
)

@NamedNativeQueries(
        {
                @NamedNativeQuery(
                        name = "Product.findByDescription",
                        query = "SELECT * FROM products p WHERE p.description = :description",
                        resultClass = Product.class
                ),
                @NamedNativeQuery(
                        name = "Product.findAllOrderByNameAsc",
                        query = "SELECT * FROM products ORDER BY name ASC",
                        resultClass = Product.class
                )
        }
)
@Table(name = "products", uniqueConstraints = {
        @UniqueConstraint(name = "sku_unique", columnNames = "stock_keeping_unit")
})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_generator")
    @SequenceGenerator(name = "product_generator", sequenceName = "product_sequence_name", allocationSize = 1)
    private Long id;
    @Column(name = "stock_keeping_unit", nullable = false)
    private String sku;
    @Column(nullable = false)
    private String name;
    private String description;
    private BigDecimal price;
    private boolean active;
    private String imageUrl;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime lastUpdated;


    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private ProductCategory category;


}
