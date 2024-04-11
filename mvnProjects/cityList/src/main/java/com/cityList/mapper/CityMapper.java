package com.cityList.mapper;

import com.cityList.dto.CityDto;
import com.cityList.entity.City;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CityMapper {

    @Mapping(source = "photo", target = "url")
    CityDto toCityDto(City city);

    @Mapping(source = "url", target = "photo")
    City toCity(CityDto city);

}
