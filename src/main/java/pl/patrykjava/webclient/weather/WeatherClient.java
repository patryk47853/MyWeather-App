package pl.patrykjava.webclient.weather;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.patrykjava.model.WeatherDto;
import pl.patrykjava.webclient.weather.dto.OpenWeatherDto;

@Component
public class WeatherClient {

    private RestTemplate restTemplate = new RestTemplate();

    private static final String WEATHER_URL = "https://api.openweathermap.org/data/2.5/";

    @Value("${api.key}")
    private String API_KEY;

    public WeatherDto getWeatherForCity(String city) {
        OpenWeatherDto openWeatherDto = callGetMethod("weather?q={city}&appid={apiKey}&units=metric&lang=en",
                OpenWeatherDto.class,
                city, API_KEY);
        return WeatherDto.builder()
                .temp((int) openWeatherDto.getMain().getTemp())
                .name(openWeatherDto.getName())
                .humidity(openWeatherDto.getMain().getHumidity())
                .pressure(openWeatherDto.getMain().getPressure())
                .windSpeed(openWeatherDto.getWind().getSpeed())
                .build();
    }

    public String getForecast(double lat, double lon) {
        return callGetMethod("forecast?lat={lat}&lon={lon}&appid={apiKey}&units=metric&lang=pl",
                String.class,
                lat, lon, API_KEY);
    }

    private <T> T callGetMethod(String url, Class<T> responseType, Object... objects) {
        return restTemplate.getForObject(WEATHER_URL + url,
                responseType, objects);
    }
}
