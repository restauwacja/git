package com.example.aib.restauwacja;

import android.app.ProgressDialog;
import android.support.v7.app.ActionBarActivity;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.aib.restauwacja.adapter.RestaurationListAdapter;
import com.example.aib.restauwacja.adapter.TableListAdapter;
import com.example.aib.restauwacja.data.Restauracja;
import com.example.aib.restauwacja.data.RestauracjaList;
import com.example.aib.restauwacja.data.User;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.NonConfigurationInstance;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Olek on 2015-06-08.
 */
@EActivity(R.layout.wyszukiwarka_restauracji)
public class WyszukiwarkaRestauracji extends ActionBarActivity {

    @ViewById
    ListView restaurationListView;

    @ViewById
    EditText wybierzKuchnieEditText;

    @ViewById
    EditText podajMiastoEditText;

    @ViewById
    EditText wpiszNazweRestauracjiEditText;

    @Bean
    @NonConfigurationInstance
    RestGetRestaurationListBackgroundTask restGetRestaurationListBackgroundTask;

    @Bean
    RestaurationListAdapter adapter;

    ProgressDialog ringProgressDialog;

    @AfterViews
    void init() {

        restaurationListView.setAdapter(adapter);
        ringProgressDialog = new ProgressDialog(this);
        ringProgressDialog.setMessage("Ładowanie...");
        ringProgressDialog.setIndeterminate(true);

    }

    @Click
    void znajdzRestauracjeButtonClicked()
    {
        ringProgressDialog.show();

        String kuchnia = wybierzKuchnieEditText.getText().toString().trim();
        String miasto = podajMiastoEditText.getText().toString().trim();
        String nazwa = wpiszNazweRestauracjiEditText.getText().toString().trim();

        Integer kuchniaDlugosc = kuchnia.length();
        Integer miastoDlugosc = miasto.length();
        Integer nazwaDlugosc = nazwa.length();

        if(kuchniaDlugosc > 0 && miastoDlugosc > 0 && nazwaDlugosc > 0)
        {
            restGetRestaurationListBackgroundTask.getRestaurationListbyNameCityAndCuisine(nazwa,miasto,kuchnia);
        }
        else if (kuchniaDlugosc > 0 && miastoDlugosc > 0)
        {
            restGetRestaurationListBackgroundTask.getRestaurationListbyCityAndCuisine(miasto, kuchnia);
        }
        else if (kuchniaDlugosc > 0 && nazwaDlugosc > 0)
        {
            restGetRestaurationListBackgroundTask.getRestaurationListbyNameAndCuisine(nazwa, kuchnia);
        }
        else if (nazwaDlugosc > 0 && miastoDlugosc > 0)
        {
            restGetRestaurationListBackgroundTask.getRestaurationListbyNameAndCity(nazwa, miasto);
        }
        else if (kuchniaDlugosc > 0)
        {
            restGetRestaurationListBackgroundTask.getRestaurationListbyCuisine(kuchnia);
        }
        else if (miastoDlugosc > 0)
        {
            restGetRestaurationListBackgroundTask.getRestaurationListbyCity(miasto);
        }
        else if (nazwaDlugosc > 0)
        {
            restGetRestaurationListBackgroundTask.getRestaurationListbyName(nazwa);
        }
        else
        {
            Toast.makeText(this,"Nie wypełniłeś żadnego pola",Toast.LENGTH_LONG).show();
        }
    }

    public void showSuccess(RestauracjaList restauracjaList){
        ringProgressDialog.dismiss();
        adapter.update(restauracjaList);
    }


    public void showError(Exception e){
        ringProgressDialog.dismiss();
        Toast.makeText(this, "Błąd\n" + e.getMessage(), Toast.LENGTH_LONG).show();
        e.printStackTrace();
    }
}
