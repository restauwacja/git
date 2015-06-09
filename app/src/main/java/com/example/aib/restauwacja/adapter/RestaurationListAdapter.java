package com.example.aib.restauwacja.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.aib.restauwacja.data.Restauracja;
import com.example.aib.restauwacja.data.RestauracjaList;
import com.example.aib.restauwacja.itemView.RestauracjaListItemView;
import com.example.aib.restauwacja.itemView.RestauracjaListItemView_;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Olek on 2015-06-09.
 */
@EBean
public class RestaurationListAdapter extends BaseAdapter {

    @RootContext
    Context context;

    List<Restauracja>list = new ArrayList<Restauracja>();

    public RestaurationListAdapter ()
    {

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Restauracja getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        RestauracjaListItemView commentItemView;
        if (convertView == null) {
            commentItemView = RestauracjaListItemView_.build(context);
        } else {
            commentItemView = (RestauracjaListItemView) convertView;
        }

        commentItemView.bind(getItem(position));

        return commentItemView;
    }

    public void update(RestauracjaList restauracjaList) {
        list.clear();
        list.addAll(restauracjaList.records);
        notifyDataSetChanged();
    }
}
