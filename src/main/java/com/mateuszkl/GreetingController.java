package com.mateuszkl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private final String template = "Hello, %s";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public RestGreeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new RestGreeting(counter.incrementAndGet(), String.format(template, name));
    }
}

