package com.workintech.s18d2.services;

import com.workintech.s18d2.exceptions.PlantException;
import com.workintech.s18d2.repository.FruitRepository;
import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.validations.PlantValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitServiceImpl implements FruitService{

    private FruitRepository fruitRepository;

    @Autowired
    public FruitServiceImpl(FruitRepository fruitRepository){
        this.fruitRepository =fruitRepository;
    }

    @Override
    public List<Fruit> getByPriceAsc() {
        return fruitRepository.getByPriceAsc();
    }

    @Override
    public List<Fruit> getByPriceDesc() {
        return fruitRepository.getByPriceDesc();
    }

    @Override
    public List<Fruit> searchByName(String name) {
        PlantValidation.validateName(name);
        return fruitRepository.searchByName(name);
    }

    @Override
    public Fruit getById(Long id) {
        PlantValidation.validateId(id);
        Optional<Fruit> fruitOptional = fruitRepository.findById(id);
        if(fruitOptional.isPresent()){
            return fruitOptional.get();
        }
        throw new PlantException("There is no plants with id : " + id, HttpStatus.NOT_FOUND);
    }

    @Override
    public Fruit save(Fruit fruit){
        return fruitRepository.save(fruit);
    }

    @Override
    public Fruit delete(Long id) {
        PlantValidation.validateId(id);
        Optional<Fruit> fruit = fruitRepository.findById(id);
                if(fruit.isPresent()){
                    fruitRepository.delete(fruit.get());
                    return fruit.get();
                } else {
                    throw new PlantException("There is no plants with id : " + id, HttpStatus.NOT_FOUND);
                }
    }

}
