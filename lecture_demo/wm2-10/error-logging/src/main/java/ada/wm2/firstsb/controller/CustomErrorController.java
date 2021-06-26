package ada.wm2.firstsb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

    Logger log = LoggerFactory.getLogger("CustomErrorController");

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            log.debug(request.getRequestURI()+" statusCode: "+statusCode);

            if (statusCode == 404)
                return "errorpages/error_404";
            else if (statusCode == 400)
                return "errorpages/error_400";
            else if (statusCode == 500)
                return "errorpages/error_500";
        }
        return "errorpages/error";
    }
}
