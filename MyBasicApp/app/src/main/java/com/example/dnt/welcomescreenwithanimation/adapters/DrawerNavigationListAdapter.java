package com.example.dnt.welcomescreenwithanimation.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.dnt.welcomescreenwithanimation.R;


/**
 * Created by dnt on 23.1.2017 г..
 */
public class DrawerNavigationListAdapter extends ArrayAdapter<String> {

    public DrawerNavigationListAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if( convertView == null ) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from( getContext() ).inflate( R.layout.navigation_drawer_list_item, parent, false );
            convertView.setTag( holder );
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.title = (TextView) convertView.findViewById( R.id.title );
        holder.title.setText( getItem( position ) );

        return convertView;
    }

    class ViewHolder {
        TextView title;
    }
}