package iccsoft.restapi.controller;


import iccsoft.restapi.model.StockModel;
import iccsoft.restapi.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StockController {

    @Autowired
    private StockRepository repository;

    @PostMapping("/stock")
    public StockModel addStock(@RequestBody StockModel stock) {
        return repository.save(stock);

    }

    @GetMapping("/stock")
    public List<StockModel> findAllStocks() {
        return (List<StockModel>) repository.findAll();
    }

    @GetMapping(path = "/stock?name={stock_name}")
    public ResponseEntity findbyId(@PathVariable("stock_name") String stock_name) {
        return repository.findById(stock_name)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/stock/{stock_name}")
    public ResponseEntity <?> delete(@PathVariable String stock_name) {
        return repository.findById(stock_name)
                .map(record -> {
                    repository.deleteById(stock_name);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping ("/stock/{stock_name}")
    public ResponseEntity update(@PathVariable("stock_name") String stock_name,
                                 @RequestBody StockModel stock) {
        return repository.findById(stock_name)
                .map(record -> {
                    record.setQuotes(stock.getQuotes());
                    StockModel updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

}
