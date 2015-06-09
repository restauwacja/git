package com.example.aib.restauwacja;

import android.app.ProgressDialog;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aib.restauwacja.data.Restauracja;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.NonConfigurationInstance;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Olek on 2015-06-08.
 */
@EActivity(R.layout.activity_restauration_details)
public class RestaurationDetails extends ActionBarActivity{

    @Bean
    @NonConfigurationInstance
    RestGetRestaurationDetailsBackgroundTask restGetRestaurationDetailsBackgroundTask;

    @ViewById
    TextView nazwaRestauracji;
    @ViewById
    TextView opisRestauracji;
    @ViewById
    TextView rodzajKuchni;
    @ViewById
    TextView ulica;
    @ViewById
    TextView miastoIKodPocztowy;
    
    @Extra
    String nazwaRestauracjiExtra;

    ProgressDialog ringProgressDialog;

    @AfterViews
    void init() {
        ringProgressDialog = new ProgressDialog(this);
        ringProgressDialog.setMessage("Ładowanie...");
        ringProgressDialog.setIndeterminate(true);
        restGetRestaurationDetailsBackgroundTask.getRestaurationDetails(nazwaRestauracjiExtra);
    }

    public void showSuccess(Restauracja restauracja)
    {
        nazwaRestauracji.setText(restauracja.name);
        opisRestauracji.setText(restauracja.opis);
        rodzajKuchni.setText(restauracja.rodzajKuchni);
        ulica.setText(restauracja.ulica + " " + restauracja.numerDomu);
        miastoIKodPocztowy.setText(restauracja.city + ""+ restauracja.postCode);
    }

    public void showError(Exception e){
        ringProgressDialog.dismiss();
        Toast.makeText(this, "Błąd\n" + e.getMessage(), Toast.LENGTH_LONG).show();
        e.printStackTrace();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
