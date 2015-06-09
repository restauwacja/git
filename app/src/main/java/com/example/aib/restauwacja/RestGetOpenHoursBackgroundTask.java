package com.example.aib.restauwacja;

import com.example.aib.restauwacja.data.CzasOtwarciaRestauracji;
import com.example.aib.restauwacja.data.Restauracja;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.rest.RestService;

/**
 * Created by Olek on 2015-06-07.
 */
@EBean
public class RestGetOpenHoursBackgroundTask {
    @RootContext
    TableListMakingReservation activity;
    @RestService
    RestauwacjaRestClient restClient;

    @Background
    void getOpenHours(Restauracja restauracja)
    {
        try
        {
            restClient.setHeader("X-Dreamfactory-Application-Name", "restauwacja");
           // CzasOtwarciaRestauracji czasOtwarciaRestauracji = restClient;
        }
        catch (Exception e)
        {

        }

    }
}
