package com.kodilla.patterns2.facade.api;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Aspect
@Component
public class FacadeWatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(FacadeWatcher.class);

    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))" +
            "&& args(orderDto, userId) && target(object) ")
    public void logEvent(OrderDto orderDto, Long userId, Object object) {
        LOGGER.info("Class: " + object.getClass().getName() + ", userId: " + userId);
        LOGGER.info("Order size: " + orderDto.getItems().size());
        String orderContent = orderDto.getItems().stream()
                .map(i -> i.getProductId() + " gty " + i.getQuantity() + "\n")
                .collect(Collectors.joining());
        LOGGER.info("items: \n" + orderContent);
    }
}
