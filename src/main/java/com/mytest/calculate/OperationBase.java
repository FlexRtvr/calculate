package com.mytest.calculate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

abstract class OperationBase implements IOperation {
    @Autowired
    private ApplicationContext appContext;

    protected Iterable<NumberEntity> GetNumbers(Iterable<Integer> ids){
        NumberRepository repository = appContext.getBean(NumberRepository.class);

        Iterable<NumberEntity> numbers;

        if (ids != null) {
            numbers = repository.findAllById(ids);
        } else {
            numbers = repository.findAll();
        }

        return numbers;
    }

}

