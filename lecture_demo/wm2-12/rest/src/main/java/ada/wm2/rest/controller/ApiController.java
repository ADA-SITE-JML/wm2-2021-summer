package ada.wm2.rest.controller;

import ada.wm2.rest.dto.UserData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class ApiController {

    String resourceUrl = "http://jsonplaceholder.typicode.com";

    @GetMapping("/user/{id}")
    public UserData getUser(@PathVariable Integer id) {
        RestTemplate restTemplate = new RestTemplate();

        UserData userData = restTemplate.getForObject(resourceUrl + "/users/"+id, UserData.class);
        return userData;
    }
}
