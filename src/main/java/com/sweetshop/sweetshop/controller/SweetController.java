
package com.sweetshop.sweetshop.controller;

import com.sweetshop.sweetshop.model.Sweet;
import com.sweetshop.sweetshop.service.SweetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sweets")
public class SweetController {

    // Service object
    private final SweetService sweetService;

    // Constructor
    public SweetController(SweetService sweetService) {
        this.sweetService = sweetService;
    }

    // add a new sweet
    @PostMapping
    public Sweet addSweet(@RequestBody Sweet sweet) {
        return sweetService.addSweet(sweet);
    }

    // get all sweets
    @GetMapping
    public List<Sweet> getAll() {
        return sweetService.getAllSweets();
    }

    //  get sweet details by id
    @GetMapping("/{id}")
    public Sweet getById(@PathVariable Long id) {
        return sweetService.getSweetById(id);
    }

    // update sweet details
    @PutMapping("/{id}")
    public Sweet updateSweet(@PathVariable Long id,
                             @RequestBody Sweet sweet) {
        return sweetService.updateSweet(id, sweet);
    }

    // delete a sweet
    @DeleteMapping("/{id}")
    public String deleteSweet(@PathVariable Long id) {
        sweetService.deleteSweet(id);
        return "Sweet deleted";
    }

    //  sell a sweet quantity kam karne ke
    @PutMapping("/{id}/sell")
    public void sellSweet(@PathVariable Long id) {
        sweetService.sellSweet(id);
    }

}
