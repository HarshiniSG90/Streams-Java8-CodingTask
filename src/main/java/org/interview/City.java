package org.interview;


public class City {

    String streetname;
    int zipcode;

    public String getStreetname() {
        return streetname;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public City(String streetname, int zipcode) {
        this.streetname = streetname;
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "City{" +
                "streetname='" + streetname + '\'' +
                ", zipcode=" + zipcode +
                '}';
    }
}
