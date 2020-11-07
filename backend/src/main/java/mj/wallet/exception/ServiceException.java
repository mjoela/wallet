package mj.wallet.exception;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ServiceException extends RuntimeException{
    final String message;

    public ServiceException( String message ){
        super( message );
        this.message = message;
    }

}
