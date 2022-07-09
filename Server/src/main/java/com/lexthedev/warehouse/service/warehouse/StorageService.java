package com.lexthedev.warehouse.service.warehouse;

import com.lexthedev.warehouse.entity.warehouse.StorageEntity;
import com.lexthedev.warehouse.exceptions.AlreadyExistsException;
import com.lexthedev.warehouse.exceptions.NotFoundException;
import com.lexthedev.warehouse.model.warehouse.Storage;
import com.lexthedev.warehouse.repository.warehouse.StorageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StorageService {
    @Autowired
    StorageRepo storageRepo;

    public Storage getOne(Long id) throws NotFoundException {
        StorageEntity storage = storageRepo.findById(id).get();
        if (storage == null) {
            throw new NotFoundException("storage not found");
        } else {
            return Storage.toModel(storage);
        }
    }

    public List<Storage> getAll() {
        Iterable<StorageEntity> storages = storageRepo.findAll();
        List<Storage> result = new ArrayList<Storage>();
        storages.forEach(elem -> result.add(Storage.toModel(elem)));

        return result;
    }

    public StorageEntity create(StorageEntity storage) throws AlreadyExistsException {
        String cell = storage.getCellName();
        if (storageRepo.findByCellName(cell) != null) {
            throw new AlreadyExistsException("Storage with cell '" + cell + "' has already created!");
        }
        return storageRepo.save(storage);
    }

    public StorageEntity edit(StorageEntity storage) throws NotFoundException {
        Long id = storage.getId();
        if (storageRepo.findById(id).isEmpty()) {
            throw new NotFoundException("storage not found");
        }
        return storageRepo.save(storage);
    }

    public String delete(Long id) throws NotFoundException {
        if (storageRepo.findById(id).isEmpty()) {
            throw new NotFoundException("product not found");
        }
        storageRepo.delete(storageRepo.findById(id).get());
        return "element with id " + id + "successfully deleted";
    }

}
