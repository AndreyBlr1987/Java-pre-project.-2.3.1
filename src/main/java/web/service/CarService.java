package web.service;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import web.Model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Component
public class CarService {
    private List<Car> carList;

    {
        carList = new ArrayList<>();
        carList.add(new Car(1, "BMW", 7));
        carList.add(new Car(2, "AUDI", 8));
        carList.add(new Car(3, "FORD", 150));
        carList.add(new Car(4, "OPEL", 43));
        carList.add(new Car(5, "SHKODA", 31));
    }

    public List<Car> carCountList(Integer count){
        if(count == null ||  count > 5 ) return carList;
        return carList.stream().limit(count).collect(Collectors.toList());

    }
}






