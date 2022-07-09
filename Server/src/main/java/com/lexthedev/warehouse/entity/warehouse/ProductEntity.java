package com.lexthedev.warehouse.entity.warehouse;

import com.lexthedev.warehouse.constants.ProductType;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    //    @ElementCollection(targetClass = ProductType.class, fetch = FetchType.EAGER)
//    @CollectionTable(name = "product_types", joinColumns = @JoinColumn(name = "product_id"))
//    @Enumerated(EnumType.STRING)
//    @ElementCollection(targetClass = ProductType.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
//    @CollectionTable(name = "product_types", joinColumns = @JoinColumn(name = "product_id"))
    @Column(unique = false, name = "type")
    private ProductType type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public ProductEntity() {
    }
}
