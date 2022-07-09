package com.lexthedev.warehouse.model.warehouse;

import com.lexthedev.warehouse.entity.document.GoodsTransactionEntity;
import com.lexthedev.warehouse.entity.warehouse.ClientEntity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Set;

public class Client {
    private Long id;
    private String name;
    private String companyName;
    private String phone;
    private String email;
//    private Set<ClientType> type;
    @ManyToOne
    @JoinColumn(name = "client")
    private Set<GoodsTransactionEntity> goodsTransactions;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    public Set<GoodsTransactionEntity> getGoodsTransactions() {
        return goodsTransactions;
    }

    public void setGoodsTransactions(Set<GoodsTransactionEntity> goodsTransactions) {
        this.goodsTransactions = goodsTransactions;
    }

    public static Client toModel(ClientEntity client) {
        Client model = new Client();
        model.setId(client.getId());
        model.setName(client.getName());
        model.setCompanyName(client.getCompanyName());
        model.setPhone(client.getPhone());
        model.setEmail(client.getEmail());
//        model.setType(client.getType());
        return model;
    }

    public Long getId() {
        return id;
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

    public Client() {
    }
}
