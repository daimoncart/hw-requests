package com.hardware.requesting.controller;

import com.hardware.requesting.model.RequestDto;
import com.hardware.requesting.service.RequestService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@Data
public class RequestController {

    private final RequestService service;

    public RequestController(RequestService service) {
        this.service = service;
    }

    @GetMapping("/requests")
    public List<RequestDto> getRequests() {
        return service.getRequests();
    }

    @GetMapping("/requests/{id}")
    public RequestDto getRequest(@PathVariable long id) {
        RequestDto requestDto = service.getRequestByRequestId(id);
        return requestDto;
    }

    @PostMapping("/requests")
    public void addRequest(@RequestBody RequestDto request) {
        service.createRequest(request);
    }

    @PatchMapping("/requests")
    public void updateRequest(@RequestBody RequestDto request) {
        service.updateRequest(request);
    }
}
