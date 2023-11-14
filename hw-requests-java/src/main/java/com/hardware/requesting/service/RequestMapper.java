package com.hardware.requesting.service;

import com.hardware.requesting.model.Request;
import com.hardware.requesting.model.RequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ON_IMPLICIT_CONVERSION)
public interface RequestMapper {
    @Mapping(target="components", source="requestDto.componentBlock")
    @Mapping(target="createdDate", ignore = true)
    @Mapping(target="total", ignore = true)
    Request fromDto(RequestDto requestDto);

    @Mapping(target="componentBlock", source="request.components")
    RequestDto toDto(Request request);
}
