package com.hillel.springsecurity.rest;


import com.hillel.springsecurity.model.Developer;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/dev")
public class DevController {
    private List<Developer> DEVELOPERS = new ArrayList<>(Arrays.asList(
            new Developer(1L, "Ivan", "Ivanov"),
            new Developer(2L, "Petr", "Petrov"),
            new Developer(3L, "Sidr", "Sidorov")
    ));

    @GetMapping
    @PreAuthorize("hasAuthority('developers:read')")
    public List<Developer> getAll() {
        return DEVELOPERS;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('developers:read')")
    public Developer getById(@PathVariable Long id) {
        return DEVELOPERS.stream()
                .filter(developer -> developer.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('developers:write')")
    public Developer create(@RequestBody Developer developer) {
        this.DEVELOPERS.add(developer);
        return developer;
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('developers:write')")
    public void deleteById(@PathVariable Long id) {
        this.DEVELOPERS.removeIf(developer -> developer.getId().equals(id));
    }
}
