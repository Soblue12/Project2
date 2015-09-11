package com.egco.project.project2;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Arrays;
import java.util.ArrayList;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {

    private Context mContext;
    private int id;
    private ArrayList<String> items ;

    public CustomListAdapter(Context mContext, int id, ArrayList<String> items) {
        this.mContext = mContext;
        this.id = id;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent)
    {
        //super.getView()

        View mView = v ;
        if(mView == null){
            LayoutInflater vi = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mView = vi.inflate(id, parent, false);
        }

        TextView text = (TextView) mView.findViewById(R.id.textView1);

        if(text != null)
        {
            text.setText(items.get(position));
        }

        return mView;
    }

}
