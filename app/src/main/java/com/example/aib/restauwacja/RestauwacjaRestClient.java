package com.example.aib.restauwacja;

import com.example.aib.restauwacja.data.EmailAndPassword;
import com.example.aib.restauwacja.data.Restauracja;
import com.example.aib.restauwacja.data.RestauracjaList;
import com.example.aib.restauwacja.data.User;

import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Post;
import org.androidannotations.annotations.rest.RequiresHeader;
import org.androidannotations.annotations.rest.Rest;
import org.androidannotations.api.rest.RestClientHeaders;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * Created by Olek on 2015-06-04.
 */
@Rest(rootUrl = "https://dsp-restauwacja2.cloud.dreamfactory.com:443/rest",
        converters = { MappingJackson2HttpMessageConverter.class })

@RequiresHeader({"X-Dreamfactory-Application-Name"})
public interface RestauwacjaRestClient extends RestClientHeaders {

        @Post("/user/session")
        User login(EmailAndPassword emailAndPassword);

        @Post("/user/register/?login=true")
        User registerNewUser(User user);

        @Get("/db/restauracja?filter=name%20%3D%20'{nazwaRestauracji}')")
        Restauracja getRestaurationDetails(String nazwaRestauracji);

        @Get("{path}")
        RestauracjaList getRestaurationListbyName(String path);

        @Get("/rest/db/Restauracja?filter=city=\"Sopot\"")
        RestauracjaList getRestaurationListbyCity();

        @Get()
        RestauracjaList getRestaurationListbyCuisine(String path);

        @Get("{path}")
        RestauracjaList getRestaurationListbyNameAndCuisine(String path);

        @Get("{path}")
        RestauracjaList getRestaurationListbyNameAndCity(String path);

        @Get("{path}")
        RestauracjaList getRestaurationListbyCityAndCuisine(String path);

        @Get("{path}")
        RestauracjaList getRestaurationListbyNameCityAndCuisine(String path);


}
