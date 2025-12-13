
package com.sweetshop.sweetshop.controller;

import com.sweetshop.sweetshop.model.Sweet;
import com.sweetshop.sweetshop.service.SweetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SweetControllerTest {

    private SweetController controller;

    @BeforeEach
    void setup() {
        controller = new SweetController(new SweetService());
    }

    @Test
    void addSweetTest() {
        Sweet sweet = controller.addSweet(new Sweet("Barfi", 25, 10));

        assertEquals("Barfi", sweet.getName());
        assertEquals(10, sweet.getQuantity());
    }

    @Test
    void getAllSweetsTest() {
        controller.addSweet(new Sweet("Ladoo", 10, 5));
        controller.addSweet(new Sweet("Jalebi", 15, 3));
      //  using list to the size
        List<Sweet> list = controller.getAll();

        assertEquals(2, list.size());
    }

    @Test
    void updateAndGetSweetTest() {
        Sweet sweet = controller.addSweet(new Sweet("Sweet", 10, 5));

        Sweet updated = controller.updateSweet(
                sweet.getId(),
                new Sweet("Sweet", 10, 3)
        );

        assertEquals(8, updated.getQuantity());
    }

    @Test
    void deleteSweetTest() {
        Sweet sweet = controller.addSweet(new Sweet("Barfi", 20, 1));
         // when the quantity becomes 1 we delete the sweet
        controller.deleteSweet(sweet.getId());

        assertThrows(RuntimeException.class,
                () -> controller.getById(sweet.getId()));
    }

    @Test
    void sellSweetTest() {
        Sweet sweet = controller.addSweet(new Sweet("Jalebi", 15, 2));

        controller.sellSweet(sweet.getId());
     // we are decreasing the sweet by 1
        assertEquals(1,
                controller.getById(sweet.getId()).getQuantity());
    }
}
