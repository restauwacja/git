package com.example.aib.restauwacja;

import com.example.aib.restauwacja.data.Restauracja;
import com.example.aib.restauwacja.data.User;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.rest.RestService;

/**
 * Created by Olek on 2015-06-08.
 */
@EBean
public class RestGetRestaurationDetailsBackgroundTask {
    @RootContext
    RestaurationDetails activity;
    @RestService
    RestauwacjaRestClient restClient;

    @Background
    void getRestaurationDetails(String nazwaRestauracji)
    {
        try {
            restClient.setHeader("X-Dreamfactory-Application-Name", "restauwacja");
            Restauracja restauracja = restClient.getRestaurationDetails(nazwaRestauracji);
            publishResult(restauracja);

        }
        catch (Exception e)
        {
            publishError(e);
        }
    }

    @UiThread
    void publishResult(Restauracja restauracja){
        activity.showSuccess(restauracja);
    }
    @UiThread
    void publishError(Exception e){
        activity.showError(e);
    }
}
