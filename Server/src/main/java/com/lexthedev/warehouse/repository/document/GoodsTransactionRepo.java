package com.lexthedev.warehouse.repository.document;

import com.lexthedev.warehouse.constants.GoodsTransactionType;
import com.lexthedev.warehouse.entity.document.GoodsTransactionEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface GoodsTransactionRepo extends CrudRepository<GoodsTransactionEntity, Long> {
//    @Query(value = "SELECT  id FROM goods_transactions")
//    Collection<GoodsTransactionEntity> findAllOutcome();
//
//    @Query(value = "SELECT  id FROM goods_transactions")
//    Collection<GoodsTransactionEntity> findAllIncome();
    List<GoodsTransactionEntity> findByTypeEquals(GoodsTransactionType type);
}
