package org.sid.Ecommerce.Exception;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class InvalidEntityException extends RuntimeException{
    private ErrorCode errorCode;
    private List<String> errors;
    public InvalidEntityException(String message){
        super(message);

    }
    public InvalidEntityException(String message,Throwable cause){
        super(message, cause);

    }
    public InvalidEntityException(String message,Throwable cause,ErrorCode errorCode){
        super(message, cause);
        this.errorCode=errorCode;

    }

    public InvalidEntityException(String message, ErrorCode errorCode){
        super(message);
        this.errorCode=errorCode;

    }
    public InvalidEntityException(String message, ErrorCode errorCode,List<String> errors){
        super(message);
        this.errorCode=errorCode;
        this.errors=errors;

    }
}
