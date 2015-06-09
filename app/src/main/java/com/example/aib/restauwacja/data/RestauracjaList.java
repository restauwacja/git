package com.example.aib.restauwacja.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Olek on 2015-06-08.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RestauracjaList {

    @JsonProperty("record")
    public List<Restauracja> records = new ArrayList<Restauracja>();
}
