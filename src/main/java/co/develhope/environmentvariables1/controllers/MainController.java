package co.develhope.environmentvariables1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/main")
public class MainController {

    @Autowired
    private Environment environment;

   @Value("${myCustomProps.authCode}")
    String myAuthCode;

    @Value("${myCustomProps.devName}")
    String myDevName;

    @GetMapping("/endpoint")
    public String mainEndPointII(){
        return myAuthCode + " \n" + myDevName;
    }


    @GetMapping("/endpointII")
    public String mainEndPoint(){
        String var = environment.getProperty("myCustomProps.authCode") + " \n" +
                     environment.getProperty("myCustomProps.devName");
        return var;
    }
}
