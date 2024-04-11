package com.cityList.service;

import com.cityList.dto.CityDto;
import com.cityList.entity.City;
import com.cityList.entity.CityProjection;
import com.cityList.exception.CityNoFoundException;
import com.cityList.mapper.CityMapper;
import com.cityList.repository.CityRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CityService {

    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    public List<CityDto> getCityList(){
        return cityRepository.findAll().stream().map(cityMapper::toCityDto).toList();
    }

    public Page<CityProjection> getCityListWithPaggination(int page, int size){
        return cityRepository.findCityBy(PageRequest.of(page, size));
    }

    public City getCity(Long id) {
        return cityRepository.findById(id)
            .orElseThrow(() -> new CityNoFoundException(String.valueOf(id)));
    }

    public City updateCity(Long id, CityDto cityDto) {
        var city = getCity(id);
         if (cityDto.name() != null) {
             city.setName(cityDto.name());
         }

         if (cityDto.url() != null) {
             city.setPhoto(cityDto.url());
         }
        return cityRepository.save(city);
    }

    public List<City> findByTerm(String term) {
        return cityRepository.findCityByTerm(term);
    }

    public List<CityProjection> findByTermNew(String term) {
        return cityRepository.findAllByNameContaining(term);
    }

    public Long count() {
        return cityRepository.count();
    }

    public void delete(Long id) {
        cityRepository.deleteById(id);
    }

    public City createCity(CityDto cityDto) {
        return cityRepository.save(cityMapper.toCity(cityDto));

    }
}
