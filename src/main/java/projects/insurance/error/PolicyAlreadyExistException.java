package projects.insurance.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Policy with that number already exist!")
public class PolicyAlreadyExistException extends RuntimeException {

    private int statusCode;

    public PolicyAlreadyExistException(String message) {
        super(message);

        this.statusCode = 409;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
