package com.example.aib.restauwacja;

import com.example.aib.restauwacja.data.Restauracja;
import com.example.aib.restauwacja.data.RestauracjaList;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.rest.RestService;

/**
 * Created by Olek on 2015-06-08.
 */
@EBean
public class RestGetRestaurationListBackgroundTask {

    @RootContext
    WyszukiwarkaRestauracji activity;
    @RestService
    RestauwacjaRestClient restClient;

    @Background
    void getRestaurationListbyName(String nazwa)
    {
        try
        {
            String path = new String();
            path = "/db/Restauracja?filter=name%3D'"+nazwa+"'";
            restClient.setHeader("X-Dreamfactory-Application-Name", "restauwacja");
            RestauracjaList listaRestauracji =restClient.getRestaurationListbyName(path);
            publishResult(listaRestauracji);
        }
        catch (Exception e)
        {
            publishError(e);
        }

    }

    @Background
    void getRestaurationListbyCity(String miasto)
    {
        try
        {
            String path = new String();
            path = "/db/Restauracja?filter=city%3D'"+miasto+"'";
            restClient.setHeader("X-Dreamfactory-Application-Name", "restauwacja");
            RestauracjaList listaRestauracji =restClient.getRestaurationListbyCity();
            publishResult(listaRestauracji);
        }
        catch (Exception e)
        {
            publishError(e);
        }

    }

    @Background
    void getRestaurationListbyCuisine(String kuchnia)
    {
        try
        {
            String path = new String();
            path = "/db/Restauracja?filter=rodzaj_kuchni%3D'"+kuchnia+"'";
            restClient.setHeader("X-Dreamfactory-Application-Name", "restauwacja");
            RestauracjaList listaRestauracji =restClient.getRestaurationListbyCuisine(path);
            publishResult(listaRestauracji);
        }
        catch (Exception e)
        {
            publishError(e);
        }
    }
    @Background
    void getRestaurationListbyNameAndCuisine(String nazwa, String kuchnia)
    {
        try
        {
            String path = new String();
            path = "/db/Restauracja?filter=rodzaj_kuchni%3D'"+kuchnia+"'%20and%20name%3D'"+nazwa+"'";
            restClient.setHeader("X-Dreamfactory-Application-Name", "restauwacja");
            RestauracjaList listaRestauracji =restClient.getRestaurationListbyNameAndCuisine(path);
            publishResult(listaRestauracji);
        }
        catch (Exception e)
        {
            publishError(e);
        }
    }
    @Background
    void getRestaurationListbyNameAndCity(String nazwa, String miasto)
    {
        try
        {
            String path = new String();
            path = "/db/Restauracja?filter=city%3D'"+miasto+"'%20and%20name%3D'"+nazwa+"'";
            restClient.setHeader("X-Dreamfactory-Application-Name", "restauwacja");
            RestauracjaList listaRestauracji =restClient.getRestaurationListbyNameAndCity(path);
            publishResult(listaRestauracji);
        }
        catch (Exception e)
        {
            publishError(e);
        }
    }
    @Background
    void getRestaurationListbyCityAndCuisine(String miasto, String kuchnia)
    {
        try
        {
            String path = new String();
            path = "/db/Restauracja?filter=city%3D'"+miasto+"'%20and%20rodzaj_kuchni%3D'"+kuchnia+"'";
            restClient.setHeader("X-Dreamfactory-Application-Name", "restauwacja");
            RestauracjaList listaRestauracji =restClient.getRestaurationListbyCityAndCuisine(path);
            publishResult(listaRestauracji);
        }
        catch (Exception e)
        {
            publishError(e);
        }
    }
    @Background
    void getRestaurationListbyNameCityAndCuisine(String nazwa, String miasto, String kuchnia)
    {
        try
        {
            String path = new String();
            path = "/db/Restauracja?filter=city%3D'"+miasto+"'%20and%20rodzaj_kuchni%3D'"+kuchnia+"'%20and%20name%3D'"+nazwa+"'";
            restClient.setHeader("X-Dreamfactory-Application-Name", "restauwacja");
            RestauracjaList listaRestauracji =restClient.getRestaurationListbyNameCityAndCuisine(path);
            publishResult(listaRestauracji);
        }
        catch (Exception e)
        {
            publishError(e);
        }
    }
    @UiThread
    void publishResult(RestauracjaList restauracjaList){
        activity.showSuccess(restauracjaList);
    }

    @UiThread
    void publishError(Exception e){
        activity.showError(e);
    }
}
