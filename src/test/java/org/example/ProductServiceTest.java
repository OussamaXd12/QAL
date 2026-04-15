package org.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class ProductServiceTest {

    @Test
    void testGetProductSuccess() {
        ProductApiClient mockClient = mock(ProductApiClient.class);
        ProductService productService = new ProductService(mockClient);

        Product expectedProduct = new Product("P001", "Laptop");

        when(mockClient.getProduct("P001")).thenReturn(expectedProduct);

        Product result = productService.getProduct("P001");

        assertEquals("P001", result.getId());
        assertEquals("Laptop", result.getName());

        verify(mockClient).getProduct("P001");
    }

    @Test
    void testGetProductInvalidFormat() {
        ProductApiClient mockClient = mock(ProductApiClient.class);
        ProductService productService = new ProductService(mockClient);

        when(mockClient.getProduct("INVALID"))
                .thenThrow(new RuntimeException("Invalid product format"));

        try {
            productService.getProduct("INVALID");
        } catch (RuntimeException e) {
            assertEquals("Invalid product format", e.getMessage());
        }

        verify(mockClient).getProduct("INVALID");
    }

    @Test
    void testGetProductApiFailure() {
        ProductApiClient mockClient = mock(ProductApiClient.class);
        ProductService productService = new ProductService(mockClient);

        when(mockClient.getProduct("P500"))
                .thenThrow(new RuntimeException("API call failed"));

        try {
            productService.getProduct("P500");
        } catch (RuntimeException e) {
            assertEquals("API call failed", e.getMessage());
        }

        verify(mockClient).getProduct("P500");
    }
}