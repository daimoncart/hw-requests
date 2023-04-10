package com.amazing.hometask.service;

import com.amazing.hometask.model.RequestDto;
import java.util.List;

public interface RequestService {
    void createRequest(RequestDto request);
    RequestDto getRequestByRequestId(long id);
    List<RequestDto> getRequests();
    void updateRequest(RequestDto request);
}
