package com.hardware.requesting.service;

import com.hardware.requesting.model.RequestDto;
import java.util.List;

public interface RequestService {
    void createRequest(RequestDto request);
    RequestDto getRequestByRequestId(long id);
    List<RequestDto> getRequests();
    void updateRequest(RequestDto request);
}
