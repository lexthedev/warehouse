package com.lexthedev.warehouse.service.document;

import com.lexthedev.warehouse.constants.GoodsTransactionType;
import com.lexthedev.warehouse.entity.document.GoodsTransactionEntity;
import com.lexthedev.warehouse.entity.warehouse.ClientEntity;
import com.lexthedev.warehouse.entity.warehouse.GoodsEntity;
import com.lexthedev.warehouse.exceptions.AlreadyExistsException;
import com.lexthedev.warehouse.exceptions.NotFoundException;
import com.lexthedev.warehouse.model.document.GoodsTransaction;
import com.lexthedev.warehouse.model.document.GoodsTransactionDTO;
import com.lexthedev.warehouse.model.warehouse.GoodsDTO;
import com.lexthedev.warehouse.repository.document.GoodsTransactionRepo;
import com.lexthedev.warehouse.repository.warehouse.ClientRepo;
import com.lexthedev.warehouse.repository.warehouse.GoodsRepo;
import com.lexthedev.warehouse.service.warehouse.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsTransactionService {
    @Autowired
    GoodsTransactionRepo goodsTransactionRepo;
    @Autowired
    GoodsRepo goodsRepo;
    @Autowired
    GoodsService goodsService;
    @Autowired
    ClientRepo clientRepo;

    public GoodsTransaction getOne(Long id) throws NotFoundException {
        GoodsTransactionEntity goodsTransaction = goodsTransactionRepo.findById(id).get();
        if (goodsTransaction == null) {
            throw new NotFoundException("product not found");
        } else {
            return GoodsTransaction.toModel(goodsTransaction);
        }
    }

    public List<GoodsTransaction> getAll() {
        Iterable<GoodsTransactionEntity> goodsTransaction = goodsTransactionRepo.findAll();
        List<GoodsTransaction> result = new ArrayList<>();
        goodsTransaction.forEach(elem -> result.add(GoodsTransaction.toModel(elem)));

        return result;
    }

    public List<GoodsTransactionDTO> getAllIncome() {
        List<GoodsTransactionEntity> goodsTransactions = goodsTransactionRepo.findByTypeEquals(GoodsTransactionType.BUY);
        List<GoodsTransactionDTO> goodsTransactionDTOList = new ArrayList<>();
        goodsTransactions.forEach(goodsTransaction -> {
            GoodsTransactionDTO goodsTransactionDTO = this.toDTO(goodsTransaction);
            goodsTransactionDTOList.add(goodsTransactionDTO);
        });

        return goodsTransactionDTOList;
    }

    public List<GoodsTransactionDTO> getAllOutcome() {
        List<GoodsTransactionEntity> goodsTransactions = goodsTransactionRepo.findByTypeEquals(GoodsTransactionType.SELL);
        List<GoodsTransactionDTO> goodsTransactionDTOList = new ArrayList<>();
        goodsTransactions.forEach(goodsTransaction -> {
            GoodsTransactionDTO goodsTransactionDTO = this.toDTO(goodsTransaction);
            goodsTransactionDTOList.add(goodsTransactionDTO);
        });

        return goodsTransactionDTOList;
    }

    public GoodsTransactionEntity create(GoodsTransactionDTO goods) throws AlreadyExistsException {
        GoodsTransactionEntity goodsTransactionEntityToSave = this.toEntity(goods);
        GoodsTransactionEntity goodsTransactionEntity = goodsTransactionRepo.save(goodsTransactionEntityToSave);
        goods.getGoods().forEach(goodsDTO -> {
            GoodsEntity goodsEntity = goodsService.toEntity(goodsDTO);
            goodsEntity.setTransaction(goodsTransactionEntity);
            goodsRepo.save(goodsEntity);
        });
        return goodsTransactionEntity;
    }

    public GoodsTransactionEntity edit(GoodsTransactionDTO goods) throws NotFoundException {
        GoodsTransactionEntity goodsTransactionEntityToSave = this.toEntity(goods);
        GoodsTransactionEntity goodsTransactionEntity = goodsTransactionRepo.save(goodsTransactionEntityToSave);
        Long id = goods.getId();
        if (goodsTransactionRepo.findById(id).isEmpty()) {
            throw new NotFoundException("goods not found");
        }
        goods.getGoods().forEach(goodsDTO -> {
            GoodsEntity goodsEntity = goodsService.toEntity(goodsDTO);
            goodsEntity.setTransaction(goodsTransactionEntity);
            goodsRepo.save(goodsEntity);
        });
        return goodsTransactionRepo.save(goodsTransactionEntity);
    }

    public Long delete(Long id) throws NotFoundException {
        GoodsTransactionEntity goodsTransaction = goodsTransactionRepo.findById(id).get();
        if (goodsTransaction == null) {
            throw new NotFoundException("goods not found");
        }
        goodsTransactionRepo.delete(goodsTransaction);
        return id;
    }

    public GoodsTransactionEntity toEntity(GoodsTransactionDTO goodsTransactionDTO) {
        GoodsTransactionEntity goodsTransaction = new GoodsTransactionEntity();
        goodsTransaction.setId(goodsTransactionDTO.getId());
        goodsTransaction.setDate(goodsTransactionDTO.getDate());
        goodsTransaction.setType(goodsTransactionDTO.getType());

        List<Long> goodsIds = new ArrayList<>();
        goodsTransactionDTO.getGoods().forEach(goodsDTO -> goodsIds.add(goodsDTO.getId()));
        List<GoodsEntity> goodsEntities = goodsRepo.findByIdIn(goodsIds);

        ClientEntity clientEntity = clientRepo.findById(goodsTransactionDTO.getClient_id()).get();
        goodsTransaction.setClient(clientEntity);

        goodsTransaction.setGoods(goodsEntities);
        return goodsTransaction;
    }

    public GoodsTransactionDTO toDTO(GoodsTransactionEntity goodsTransaction) {
        GoodsTransactionDTO goodsTransactionDTO = new GoodsTransactionDTO();
        goodsTransactionDTO.setId(goodsTransaction.getId());
        goodsTransactionDTO.setDate(goodsTransaction.getDate());
        goodsTransactionDTO.setClient_id(goodsTransaction.getClient().getId());
        goodsTransactionDTO.setType(goodsTransaction.getType());
        List<GoodsDTO> goodsDTOList = new ArrayList<>();
        goodsTransaction.getGoods().forEach(good -> {
            GoodsDTO goodsDTO = new GoodsDTO();
            goodsDTO.setId(good.getId());
            goodsDTO.setCell_id(good.getCell().getId());
            goodsDTO.setProduct_id(good.getProduct().getId());
            goodsDTO.setValue(good.getValue());
            goodsDTOList.add(goodsDTO);
        });
        goodsTransactionDTO.setGoods(goodsDTOList);
        return goodsTransactionDTO;
    }
}
