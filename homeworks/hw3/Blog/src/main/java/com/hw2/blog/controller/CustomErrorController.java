package com.hw2.blog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/error")
public class CustomErrorController implements ErrorController {

    Logger log = LoggerFactory.getLogger("CustomErrorController");

    @GetMapping("")
    public String handleErrors(HttpServletRequest request, Model model){

        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            log.debug(request.getRequestURI()+" statusCode: "+statusCode);

            if (statusCode == 404)
                return "errors/error_404";
            else if (statusCode == 400)
                return "errors/error_400";
            else if (statusCode == 500)
                return "errors/error_500";
        }


        return "errors/error";

    }


}
