package com.example.aib.restauwacja.data;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.sql.Time;

/**
 * Created by Olek on 2015-06-08.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class CzasOtwarciaRestauracji implements Serializable {

    Integer id;

    @JsonProperty("godzina_otwarcia")
    Time godzinaOtwarcia;

    @JsonProperty("godzina_zamkniecia")
    Time godzinaZamkniecia;

    @JsonProperty("id_restauracji")
    Integer idRestauracji;

    @JsonProperty("id_dnia_tygodnia")
    Integer idDniaTygodnia;

}
