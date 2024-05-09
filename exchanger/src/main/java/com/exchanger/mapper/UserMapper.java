package com.exchanger.mapper;

import com.exchanger.dto.records.UserRecord;
import com.exchanger.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User forRecord(UserRecord user);
}
