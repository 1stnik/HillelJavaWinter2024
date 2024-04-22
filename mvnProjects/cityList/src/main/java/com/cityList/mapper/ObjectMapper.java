package com.cityList.mapper;

import com.cityList.dto.Res;
import com.cityList.dto.Target;
import java.util.List;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ObjectMapper {

    @Mapping(target = "fullName", expression = "java(res.getFirstName() + \" \" + res.getLastName())")
    @Mapping(source = "res.height", target = "height", qualifiedByName = "converter")
//    @Mapping(source = "age", target = "age")
    @Mapping(source = "res.age", target = "age")
    Target toTarget(Res res, Long age);

    @Named("converter")
    static int convert(double source) {
        return (int) (source * 100);
    }

    @IterableMapping(qualifiedByName = "ResMapper")
    List<Target> toTargets(List<Res> res);


    @Named("ResMapper")
    @Mapping(target = "fullName", expression = "java(res.getFirstName() + \" \" + res.getLastName())")
    @Mapping(source = "height", target = "height", qualifiedByName = "converter")
    Target toTarget(Res res);


}
