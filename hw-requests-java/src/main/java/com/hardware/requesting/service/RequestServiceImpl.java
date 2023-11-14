package com.hardware.requesting.service;

import com.hardware.requesting.exception.RequestServiceException;
import com.hardware.requesting.model.Request;
import com.hardware.requesting.model.RequestDto;
import com.hardware.requesting.repository.RequestRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RequestServiceImpl implements RequestService {

    private final RequestRepository repository;
    private RequestMapper mapper;
    static final String MISSING_REQUEST = "The request with such id is missing.";

    public RequestServiceImpl(RequestRepository repository) {
        this.repository = repository;
        mapper = Mappers.getMapper(RequestMapper.class);
    }

    @Override
    public void createRequest(RequestDto requestDto) {
        var request = mapper.fromDto(requestDto);
        var total = request.getComponents().stream()
                .map(it -> it.getPrice() * it.getQuantity())
                .reduce(0.0, Double::sum);
        request.setTotal(total);
        repository.save(request);
    }

    @Override
    public RequestDto getRequestByRequestId(long id) {
        Optional<Request> requestOptional = repository.findById(id);
        if (requestOptional.isEmpty()) {
            throw new RequestServiceException(MISSING_REQUEST);
        }
        RequestDto requestDto = mapper.toDto(requestOptional.get());
        return requestDto;
    }

    @Override
    public List<RequestDto> getRequests() {
        List<Request> requests = (List<Request>) repository.findAll();
        List<RequestDto> requestDtos = new ArrayList<>();
        requests.stream().forEach(request -> {
            var requestDto = mapper.toDto(request);
            requestDtos.add(requestDto);
        });
        return requestDtos;
    }

    @Override
    public void updateRequest(RequestDto requestDto) {
        Optional<Request> requestOptional = repository.findById(requestDto.getId());
        if (requestOptional.isEmpty()) {
            throw new RequestServiceException(MISSING_REQUEST);
        }
        var request = requestOptional.get();
        request.setStatus(requestDto.getStatus());
        repository.save(request);
    }
}
