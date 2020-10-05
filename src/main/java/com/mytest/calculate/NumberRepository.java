package com.mytest.calculate;

import org.springframework.data.repository.CrudRepository;

public interface NumberRepository extends CrudRepository<NumberEntity, Integer> {
}
