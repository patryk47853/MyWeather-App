package pl.patrykjava.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeatherDto {

    private float temp;
    private String cityTemp;
    private String name;
    private int pressure;
    private int humidity;
    private float windSpeed;
}
