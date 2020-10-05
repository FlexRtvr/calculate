package com.mytest.calculate;

public class OperationSum extends OperationBase {

    @Override
    public String DoOperation(Iterable<Integer> ids) {
        Iterable<NumberEntity> numbers= GetNumbers(ids);
        if (!numbers.iterator().hasNext())
        {
            return "Значения не найдены";
        }
        long res = 0;
        for (NumberEntity number : numbers) {
            res += number.getValue();
        }
        return String.valueOf(res);
    }
}
