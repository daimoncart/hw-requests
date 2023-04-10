package com.amazing.hometask.service;

import com.amazing.hometask.model.Component;
import com.amazing.hometask.model.ComponentDto;
import com.amazing.hometask.model.Request;
import com.amazing.hometask.model.RequestDto;
import lombok.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RequestMapperTest {
    private RequestMapper mapper = Mappers.getMapper(RequestMapper.class);

    @Test
    void fromDto() {
        RequestDto requestDto = new RequestDto();
        requestDto.setId(23);
        requestDto.setReasoning("I need this for my studies");
        requestDto.setStatus("Accepted");

        ComponentDto componentDto = new ComponentDto();
        componentDto.setComponentId(993);

        requestDto.setComponentBlock(Collections.singletonList(componentDto));

        Request request = mapper.fromDto(requestDto);
        assertEquals(requestDto.getId(), request.getId());
        assertEquals(requestDto.getReasoning(), request.getReasoning());
        assertEquals(requestDto.getStatus(), request.getStatus());
        assertEquals(requestDto.getComponentBlock().get(0).getComponentId(), request.getComponents().get(0).getComponentId());
    }

    @Test
    void toDto() {
        Request request = new Request();
        request.setId(29);
        request.setReasoning("I need this for my other studies");
        request.setStatus("New");

        Component component = new Component();
        component.setComponentId(49331);

        request.setComponents(Collections.singletonList(component));

        RequestDto requestDto = mapper.toDto(request);
        assertEquals(request.getId(), requestDto.getId());
        assertEquals(request.getReasoning(), requestDto.getReasoning());
        assertEquals(request.getStatus(), requestDto.getStatus());
        assertEquals(request.getComponents().get(0).getComponentId(), requestDto.getComponentBlock().get(0).getComponentId());
    }
}