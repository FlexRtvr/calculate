package com.mytest.calculate;

import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/calc")
public class CalculateController {

    private final ApplicationContext appContext;

    public CalculateController(ApplicationContext appContext) {
        this.appContext = appContext;
    }

    @PostMapping("/registerNumber")
    public ResponseEntity<String> RegisterNumber(int newNumber) {

        NumberRepository repository = appContext.getBean(NumberRepository.class);

        NumberEntity numberEntity;

        try {

            numberEntity = repository.save(new NumberEntity(newNumber));

        } catch (Exception exception) {
            return new ResponseEntity<>("Неудачная попытка сохранить запись", HttpStatus.INTERNAL_SERVER_ERROR);
        }


        return new ResponseEntity<>(String.format("Новое значение: %d успешно зарегистрировано, id = %d", newNumber, numberEntity.getId()), HttpStatus.OK);
    }

    @GetMapping("/operation")
    public ResponseEntity<String> Operation(String operation, String id) {

        if(operation==null){
            return new ResponseEntity<>("Имя операции должно быть задано", HttpStatus.BAD_REQUEST);
        }

        ArrayList<Integer> ids = null;

        if (id != null) {
            String[] strings = id.split(",");

            ids = new ArrayList<>();

            for (String string : strings) {
                ids.add(Integer.decode(string));
            }
        }

        IOperation operationImpl;

        switch (operation.toLowerCase()){
            case "sum":
                operationImpl = (IOperation) appContext.getBean("OperationSum");
                break;
            case "avg":
                operationImpl = (IOperation) appContext.getBean("OperationAvg");
                break;
            case "min":
                operationImpl = (IOperation) appContext.getBean("OperationMin");
                break;
            case "max":
                operationImpl = (IOperation) appContext.getBean("OperationMax");
                break;
            default:
                return new ResponseEntity<>(String.format("Запрошенная операция:[%s] не поддерживается", operation), HttpStatus.BAD_REQUEST);
        }

        String res = operationImpl.DoOperation(ids);

        return new ResponseEntity<>(String.format("результат операции: %s", res), HttpStatus.OK);

    }

}