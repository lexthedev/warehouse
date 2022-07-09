package com.lexthedev.warehouse.entity.warehouse;

import com.lexthedev.warehouse.constants.ClientType;
import com.lexthedev.warehouse.entity.TodoEntity;
import com.lexthedev.warehouse.entity.document.GoodsTransactionEntity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "clients")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    private String name;
    private String phone;
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<GoodsTransactionEntity> goodsTransactionEntities;

//    @ElementCollection(targetClass = ClientType.class, fetch = FetchType.EAGER)
//    @CollectionTable(name = "client_types", joinColumns = @JoinColumn(name = "client_id"))
//    @Enumerated(EnumType.STRING)
//    private Set<ClientType> type;
//    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
//    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
//    @Enumerated(EnumType.STRING)
//    private Set<Role> roles;

    public Long getId() {
        return id;
    }

    public List<GoodsTransactionEntity> getGoodsTransactionEntities() {
        return goodsTransactionEntities;
    }

    public void setGoodsTransactionEntities(List<GoodsTransactionEntity> goodsTransactionEntities) {
        this.goodsTransactionEntities = goodsTransactionEntities;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public Set<ClientType> getType() {
//        return type;
//    }
//
//    public void setType(Set<ClientType> type) {
//        this.type = type;
//    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public ClientEntity() {
    }
}
