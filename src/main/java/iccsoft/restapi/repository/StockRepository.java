package iccsoft.restapi.repository;

import iccsoft.restapi.model.StockModel;
import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository<StockModel, String> {
    StockModel findByName(String stock_name);
}
