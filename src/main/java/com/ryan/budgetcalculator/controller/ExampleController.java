package com.ryan.budgetcalculator.controller;

import com.ryan.budgetcalculator.entity.HelloWorld;
import com.ryan.budgetcalculator.entity.dto.HelloWorldDTO;
import com.ryan.budgetcalculator.repository.HelloWorldRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExampleController {

    private final HelloWorldRepository helloWorldRepository;

    @GetMapping("test")
    public ResponseEntity<HelloWorldDTO> helloWorld() {
        HelloWorld helloWorld = new HelloWorld(null, "Hello World!");
        helloWorldRepository.save(helloWorld);
        return ResponseEntity.ok().body(new HelloWorldDTO(helloWorld.getId(),
                helloWorld.getHelloWorld()));
    }

}
