package com.maddy.studentmanagementservice.contoller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/")
public class MyRestController {

    private String name;

    private static Logger logger = Logger.getLogger(MyRestController.class.getName());

    @GetMapping("/greet")
    public String greet(String greetee) {

        if(greetee == null){
            return "Hello";
        }
        else {
            this.name = greetee;
            return "Hello " + this.name;
        }
//        if (greetee != null) {
//            this.name = greetee;
//        }

       // return "Hello " + this.name;  // if greetee is null, you see the previous user's data
    }

    @GetMapping("/secureSeed")
    public void logSecureSeed() {

        SecureRandom sr = new SecureRandom();
        //sr.setSeed(123456L);   // Non-compliant
        int v = sr.nextInt(32);

        logger.log(Level.INFO, "Secure password is {0}", v);

    }

    @GetMapping("/addSalt")
    public void addSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        String password = System.getProperty("salt.password");
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 10000, 256); // Compliant

        //byte[] salt = "notrandom".getBytes();  // Non-compliant, predictable salt
        //PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 10000, 256); // Non-compliant, predictable salt
        logger.log(Level.INFO, "Salt is password is {0}", spec.getSalt());
    }


}
