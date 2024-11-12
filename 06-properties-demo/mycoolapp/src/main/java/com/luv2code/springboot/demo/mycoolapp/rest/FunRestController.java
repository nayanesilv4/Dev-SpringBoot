package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    //adicionar propriedades para coach.name e team.name
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    //expor um novo endpoint para "teaminfo"
    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Treinador: " + coachName + ", Time: " + teamName;
    }

    @GetMapping("/")
    public String sayHello(){
        return "Hello World!";
    }

    // expor um novo endpoint para "workout"
    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 5km!";
    }

    // expor um novo endpoint para "fortune"
    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Today is your lucky day.";
    }
}
