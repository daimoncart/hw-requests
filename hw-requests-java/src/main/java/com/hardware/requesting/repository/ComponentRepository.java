package com.hardware.requesting.repository;

import com.hardware.requesting.model.Component;
import org.springframework.data.repository.CrudRepository;

public interface ComponentRepository extends CrudRepository<Component, Long> {
}
