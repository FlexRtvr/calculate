package com.mytest.calculate;

public class OperationAvg extends OperationBase {

    @Override
    public String DoOperation(Iterable<Integer> ids) {
        Iterable<NumberEntity> numbers= GetNumbers(ids);
        if (!numbers.iterator().hasNext())
        {
            return "Значения не найдены";
        }

        double res = 0;
        long count = 0;
        for (NumberEntity number : numbers) {
            res += number.getValue();
            count++;
        }
        res = res/count;
        return String.valueOf(res);
    }
}
