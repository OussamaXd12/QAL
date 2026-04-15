package org.example;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class OrderControllerTest {

    @Test
    void testCreateOrderCallsOrderService() {
        OrderService orderServiceMock = mock(OrderService.class);
        OrderController orderController = new OrderController(orderServiceMock);
        Order order = new Order(1L, "burger");

        orderController.createOrder(order);

        verify(orderServiceMock).createOrder(order);
    }

    @Test
    void testOrderServiceCallsOrderDao() {
        OrderDao orderDaoMock = mock(OrderDao.class);
        OrderService orderService = new OrderService(orderDaoMock);
        Order order = new Order(1L, "burger");

        orderService.createOrder(order);

        verify(orderDaoMock).saveOrder(order);
    }
}