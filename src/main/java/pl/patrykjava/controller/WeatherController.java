package pl.patrykjava.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.patrykjava.model.WeatherDto;
import pl.patrykjava.service.WeatherService;

@Controller
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public String home(@RequestParam String city, Model model) {
        WeatherDto weather = weatherService.getWeather(city);
        model.addAttribute("weather", weather);
        return "weather";
    }
}

