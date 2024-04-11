package com.cityList.controller;

import com.cityList.dto.CityDto;
import com.cityList.entity.City;
import com.cityList.entity.CityProjection;
import com.cityList.repository.CityRepository;
import com.cityList.service.CityService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 0.0.1
 */
@RestController
@RequestMapping("/api/v1/cities")
@RequiredArgsConstructor
@Slf4j
public class CityController {

    private final CityService cityService;

    @GetMapping()
    public List<CityDto> getAllCities() {
        return cityService.getCityList();
    }

    @GetMapping("/page")
    public Page<CityProjection> getAllCities(@RequestParam int page, @RequestParam int size) {
        return cityService.getCityListWithPaggination(page, size);
    }

    @GetMapping("/{id}")
    public City getCity(@PathVariable Long id) {
        return cityService.getCity(id);
    }

    @PutMapping("/{id}")
    public City getCity(@PathVariable Long id, @RequestBody CityDto cityDto) {
        return cityService.updateCity(id, cityDto);
    }

    @GetMapping("/search/{term}")
    public List<City> getAllCitiesByTerm(@PathVariable String term) {
        return cityService.findByTerm(term);
    }

    @GetMapping("/search/{term}/new")
    public List<CityProjection> getAllCitiesByTermNew(@PathVariable String term) {
        return cityService.findByTermNew(term);
    }

    @GetMapping("/count")
    public Long cityCount() {
        return cityService.count();
    }

    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable Long id) {
         cityService.delete(id);
    }

    @PostMapping
    public City createCity(@RequestBody CityDto cityDto) {
        return cityService.createCity(cityDto);
    }
}
