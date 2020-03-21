package org.javaboy.security.mulitsecuritydemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/admin/hello")
    public String admin() {
        return "hello admin!";
    }

    @GetMapping("/admin/db/hello")
    public String admin2() {
        return "/admin/db/hello";
    }

    @GetMapping("/user/hello")
    public String user() {
        return "hello user!";
    }

    @GetMapping("/db/hello")
    public String dba() {
        return "hello dba!";
    }



}