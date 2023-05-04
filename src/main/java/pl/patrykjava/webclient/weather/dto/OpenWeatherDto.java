package pl.patrykjava.webclient.weather.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class OpenWeatherDto {

    private OpenWeatherMainDto main;
    private OpenWeatherWindDto wind;
    private List<OpenWeatherWeatherDto> weather;
    private String name;
}
