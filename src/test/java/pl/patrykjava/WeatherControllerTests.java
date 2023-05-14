package pl.patrykjava;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import pl.patrykjava.controller.WeatherController;
import pl.patrykjava.model.WeatherDto;
import pl.patrykjava.service.WeatherService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WeatherControllerTests {

    @Mock
    private WeatherService weatherService;

    @InjectMocks
    private WeatherController weatherController;

    @Mock
    private Model theModel;

    @Test
    public void home_ShouldReturnHomeView_WhenCityIsNull() {
        // Arrange
        String city = null;

        // Act
        String viewName = weatherController.home(city, theModel);

        // Assert
        assertEquals("home", viewName);
    }

    @Test
    public void home_ShouldReturnErrorView_WhenWeatherIsNull() {
        // Arrange
        String city = "TestCity";
        when(weatherService.getWeather(city)).thenReturn(null);

        // Act
        String viewName = weatherController.home(city, theModel);

        // Assert
        assertEquals("error", viewName);
    }

    @Test
    public void home_ShouldAddWeatherToModelAndReturnWeatherView_WhenWeatherIsNotNull() {
        // Arrange
        String city = "Warsaw";
        WeatherDto weather = new WeatherDto();
        when(weatherService.getWeather(city)).thenReturn(weather);

        // Act
        String viewName = weatherController.home(city, theModel);

        // Assert
        assertEquals("weather", viewName);
        verify(theModel).addAttribute("weather", weather);
    }
}
