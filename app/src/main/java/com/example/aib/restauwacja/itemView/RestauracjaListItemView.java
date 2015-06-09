package com.example.aib.restauwacja.itemView;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.aib.restauwacja.R;
import com.example.aib.restauwacja.data.Restauracja;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Olek on 2015-06-09.
 */

@EViewGroup(R.layout.table_list_item)
public class RestauracjaListItemView extends RelativeLayout {

    public RestauracjaListItemView(Context context) {
        super(context);
    }

    @ViewById
    TextView nazwaRestauracjiRestauracjaListItem;
    @ViewById
    TextView adresRestauracjiRestauracjaListItem;


    public void bind(Restauracja restauracja)
    {
        nazwaRestauracjiRestauracjaListItem.setText(restauracja.name);
        adresRestauracjiRestauracjaListItem.setText(restauracja.ulica + " " + restauracja.numerDomu + " "+restauracja.postCode);
    }
}
