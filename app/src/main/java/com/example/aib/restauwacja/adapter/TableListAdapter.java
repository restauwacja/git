package com.example.aib.restauwacja.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.aib.restauwacja.data.RestauracjaList;
import com.example.aib.restauwacja.data.Wiersz;
import com.example.aib.restauwacja.itemView.TableListItemView;
import com.example.aib.restauwacja.itemView.TableListItemView_;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Olek on 2015-06-07.
 */
@EBean
public class TableListAdapter extends BaseAdapter {

    @RootContext
    Context context;

    List<Wiersz>listaGodzin = new ArrayList<Wiersz>();

    public TableListAdapter ()
    {

    }

    @Override
    public int getCount() {
        return listaGodzin.size();
    }

    @Override
    public Wiersz getItem(int i) {
        return listaGodzin.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TableListItemView tableListItemView;
        if (convertView == null) {
            tableListItemView = TableListItemView_.build(context);
        } else {
            tableListItemView = (TableListItemView) convertView;
        }

        tableListItemView.bind(getItem(position));

        return tableListItemView;
    }


}
