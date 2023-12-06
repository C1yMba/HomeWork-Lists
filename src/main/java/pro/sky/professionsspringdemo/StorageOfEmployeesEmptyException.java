package pro.sky.professionsspringdemo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class StorageOfEmployeesEmptyException extends RuntimeException {
    public StorageOfEmployeesEmptyException(String message) {
            super(message);
        }
    }
