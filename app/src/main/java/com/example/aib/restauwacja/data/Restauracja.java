package com.example.aib.restauwacja.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by Olek on 2015-06-07.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Restauracja implements Serializable {
    public Integer id;

    public String name;

    public String city;

    public String voivodeship;

    @JsonProperty("post_code")
    public String postCode;

    @JsonProperty("id_restauratora")
    public Integer idRestauratora;

    @JsonProperty("szerokosc_geograficzna")
    public String szerokoscGeograficzna;

    @JsonProperty("dlugosc_geograficzna")
    public String dlugoscGeograficzna;

    @JsonProperty("ilosc_stolikow")
    public Integer iloscStolikow;

    public String ulica;

    @JsonProperty("numer_domu")
    public Integer numerDomu;

    @JsonProperty("rodzaj_kuchni")
    public String rodzajKuchni;

    public String opis;



}
