package com.assignment02.assignment.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ExceptionController implements ErrorController {

    private final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    @RequestMapping("/error")
    public String handleException(HttpServletRequest request) {
        logger.debug("entered ExceptionController.handleException()");
        Object statusCode = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (statusCode != null) {
            logger.debug("status code {}", statusCode);
            switch (Integer.parseInt(statusCode.toString())) {
                case 400:
                    return "error_pages/error_400";
                case 404:
                    return "error_pages/error_404";
                case 500:
                    return "error_pages/error_500";
            }
        }
        logger.debug("exiting ExceptionController.handleException()");
        return "error";
    }
}
