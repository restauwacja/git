package com.example.aib.restauwacja;

import android.support.v7.app.ActionBarActivity;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.NonConfigurationInstance;


/**
 * Created by Olek on 2015-06-08.
 */
@EActivity(R.layout.tablelist_listview_layout)
public class TableListMakingReservation extends ActionBarActivity{
    @Bean
    @NonConfigurationInstance
    RestGetOpenHoursBackgroundTask restGetOpenHoursBackgroundTask;
}
