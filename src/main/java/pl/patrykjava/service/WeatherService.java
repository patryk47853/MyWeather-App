package pl.patrykjava.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.patrykjava.model.WeatherDto;
import pl.patrykjava.webclient.weather.WeatherClient;

@Service
@Slf4j
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherClient weatherClient;
    public WeatherDto getWeather(String city) {
        return weatherClient.getWeatherForCity(city);
    }

}
