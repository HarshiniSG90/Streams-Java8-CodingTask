package org.interview;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TestWeather {

    public static void main(String args[])
    {
        List<Weather> weatherList = new ArrayList<Weather>();

        weatherList.add(new Weather("sunny",33.0));
        weatherList.add(new Weather("Rainy",17.0));
        weatherList.add(new Weather("Cloudy",23.0));
        weatherList.add(new Weather("Cold",3.0));
        weatherList.add(new Weather("Hot",37.0));
        weatherList.add(new Weather("Snow",0.0));
        weatherList.add(new Weather("Freezing",-15.0));

       //weatherList.stream().map(Weather::getTemperature).sorted().forEach(System.out::println);
       // weatherList.stream().sorted(Weather::getTemperature).forEach(System.out::println);
        weatherList.stream().sorted((p1,p2)->p1.getTemperature().compareTo(p2.getTemperature())).forEach(System.out::println);
      //weatherList.stream().map(Weather::getTemperature).sorted((p1,p2)->p1.compareTo(p2)).forEach(System.out::println);
    }
}
