package com.mytest.calculate;


public class OperationMin extends OperationBase {

    @Override
    public String DoOperation(Iterable<Integer> ids) {
        Iterable<NumberEntity> numbers= GetNumbers(ids);
        if (!numbers.iterator().hasNext())
        {
            return "Значения не найдены";
        }
        long res = numbers.iterator().next().getValue();
        for (NumberEntity number : numbers) {
            if (number.getValue()< res)
            {
                res = number.getValue();
            }
        }
        return String.valueOf(res);
    }
}
