
package com.sweetshop.sweetshop.service;

import com.sweetshop.sweetshop.model.Sweet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SweetService {

    // simple list to store sweets
    private List<Sweet> sweetList = new ArrayList<>();
    private long idCounter = 1;

    // add sweet
    public Sweet addSweet(Sweet sweet) {
        sweet.setId(idCounter++);
        sweetList.add(sweet);
        return sweet;
    }

    // get all sweets
    public List<Sweet> getAllSweets() {
        return sweetList;
    }

    // get sweet by id
    public Sweet getSweetById(Long id) {
        for (Sweet sweet : sweetList) {
            if (sweet.getId().equals(id)) {
                return sweet;
            }
        }
        throw new RuntimeException("Sweet not found");
    }

    // update sweet
    public Sweet updateSweet(Long id, Sweet updatedSweet) {
        Sweet existing = getSweetById(id);

        existing.setName(updatedSweet.getName());
        existing.setPrice(updatedSweet.getPrice());
        existing.setQuantity(
                existing.getQuantity() + updatedSweet.getQuantity()
        );

        return existing;
    }

    // delete sweet
    public void deleteSweet(Long id) {
        Sweet sweet = getSweetById(id);
        sweetList.remove(sweet);
    }

    // sell sweet
    public void sellSweet(Long id) {
        Sweet sweet = getSweetById(id);

        if (sweet.getQuantity() <= 1) {
            sweetList.remove(sweet);
        } else {
            sweet.setQuantity(sweet.getQuantity() - 1);
        }
    }
}
