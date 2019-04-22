package de.struktuhr.resourceserver.control;

import de.struktuhr.resourceserver.entity.Order;
import de.struktuhr.resourceserver.exception.NotFoundException;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class OrderService {

    private Map<String, Order> map;

    public OrderService() {
        initData();
    }


    public Order getOrder(String id) {
        if (!map.containsKey(id)) {
            throw new NotFoundException("Order " + id + " not found");
        }
        return map.get(id);
    }

    private void initData() {
        map = new LinkedHashMap<>();
        map.put("1", new Order("1", "Order 1", "0500"));
        map.put("2", new Order("2", "Order 2", "0500"));
        map.put("3", new Order("3", "Order 3", "1522"));
    }
}
