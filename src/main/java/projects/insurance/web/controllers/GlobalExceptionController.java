package projects.insurance.web.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler({Throwable.class})
    public ModelAndView handleSqlException(Throwable e) {

        ModelAndView model = new ModelAndView("error");

        Throwable throwable = e;

        while (throwable.getCause() != null) {
            throwable = throwable.getCause();
        }

        model.addObject("message", throwable.getMessage());

        return model;
    }
}
