package com.example.aib.restauwacja.itemView;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.aib.restauwacja.R;
import com.example.aib.restauwacja.adapter.TableListAdapter;
import com.example.aib.restauwacja.data.Wiersz;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Olek on 2015-06-07.
 */
@EViewGroup(R.layout.tablelist_row_layout)
public class TableListItemView extends LinearLayout {

    @ViewById
    TextView godzina;
    @ViewById
    TextView liczbaWolnychStolikow;

    public TableListItemView (Context context)
    {
        super(context);
    }

    public void bind(Wiersz wiersz)
    {
        godzina.setText(wiersz.godzina);
        liczbaWolnychStolikow.setText(wiersz.liczbaWolnychStolikow);
    }

}
