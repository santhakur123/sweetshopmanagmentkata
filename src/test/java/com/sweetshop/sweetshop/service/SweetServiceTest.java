
package com.sweetshop.sweetshop.service;

import com.sweetshop.sweetshop.model.Sweet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SweetServiceTest {

    private SweetService service;

    @BeforeEach
    void setup() {
        service = new SweetService();
    }

    @Test
    void addAndGetSweetTest() {
        Sweet sweet = service.addSweet(new Sweet("Barfi", 25, 10));

        Sweet result = service.getSweetById(sweet.getId());

        assertEquals("Barfi", result.getName());
        assertEquals(10, result.getQuantity());
    }

    @Test
    void getAllSweetsTest() {
        service.addSweet(new Sweet("Ladoo", 10, 5));
        service.addSweet(new Sweet("Jalebi", 15, 3));

        assertEquals(2, service.getAllSweets().size());
    }






}
