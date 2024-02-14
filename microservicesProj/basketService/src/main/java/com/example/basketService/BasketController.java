package com.example.basketService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/baskets")
public class BasketController {
    private final BasketService basketService;
    @GetMapping
    public List<Basket> findAll(){
        return basketService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Basket> findById(@PathVariable Long id){
        Optional<Basket> basket = basketService.findById(id);
        return basket.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Basket save(@RequestBody Basket basket){
        return basketService.save(basket);
    }
    @PutMapping("/{id}")
    public Basket update(@RequestBody Basket basket, @PathVariable Long id){
        basket.setId(id);
        return basketService.save(basket);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        basketService.deleteById(id);
    }
}
