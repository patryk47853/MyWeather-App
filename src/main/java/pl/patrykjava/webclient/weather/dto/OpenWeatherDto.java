package pl.patrykjava.webclient.weather.dto;

import lombok.Getter;

@Getter
public class OpenWeatherDto {

    private OpenWeatherMainDto main;
    private OpenWeatherWindDto wind;
}
