package org.interview;

public class Weather {

    private String place;
    private  Double temperature;

    Weather()
    {

    }
    Weather(String place , Double temperature)
    {
        this.place = place;
        this.temperature = temperature;
    }
    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "place='" + place + '\'' +
                ", temperature=" + temperature +
                '}';
    }
}
