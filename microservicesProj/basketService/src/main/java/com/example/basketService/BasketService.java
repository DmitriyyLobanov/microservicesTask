package com.example.basketService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BasketService {
    private final BasketRepository basketRepository;
    public List<Basket> findAll(){
        return  basketRepository.findAll();
    }
    public Optional<Basket> findById(Long id){
        return basketRepository.findById(id);
    }
    public Basket save(Basket task){
        return basketRepository.save(task);
    }
    public void deleteById(Long id){
        basketRepository.deleteById(id);
    }
}
