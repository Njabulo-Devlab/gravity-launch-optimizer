package com.gravitylaunchoptimizer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SimulationController {

    private final GravityCalculator calculator = new GravityCalculator();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/")
    public String home(Model model) throws JsonProcessingException {
        model.addAttribute("planets", PlanetDatabase.getPlanets().keySet());
        model.addAttribute("selectedPlanet", "Earth");
        model.addAttribute("altitude", 10000.0);
        model.addAttribute("velocity", 300.0);
        model.addAttribute("angle", 45.0);
        model.addAttribute("hasResult", false);
        model.addAttribute("trajectoryJson", "[]");
        return "index";
    }

    @GetMapping("/simulate")
    public String simulate(
            @RequestParam String planet,
            @RequestParam double altitude,
            @RequestParam double velocity,
            @RequestParam double angle,
            Model model) throws JsonProcessingException {

        Planet selectedPlanet = PlanetDatabase.get(planet);
        SimulationResult result =
                calculator.simulateFlight(selectedPlanet, altitude, velocity, angle);

        model.addAttribute("planets", PlanetDatabase.getPlanets().keySet());
        model.addAttribute("selectedPlanet", planet);
        model.addAttribute("altitude", altitude);
        model.addAttribute("velocity", velocity);
        model.addAttribute("angle", angle);
        model.addAttribute("hasResult", true);
        model.addAttribute("result", result);
        model.addAttribute("trajectoryJson", objectMapper.writeValueAsString(result.getTrajectory()));

        return "index";
    }
}
