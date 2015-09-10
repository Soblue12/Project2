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
    private String[] items ;

    //TextView text = (TextView)findViewById(R.id.textView1);

    /*public CustomListAdapter(Context context, int textViewResourceId , List<String> list )
    {
        super(context, textViewResourceId, list);
        mContext = context;
        id = textViewResourceId;
        items = list ;
    }*/

    public CustomListAdapter(Context mContext, int id, String[] items) {
        this.mContext = mContext;
        this.id = id;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.length;
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
        //TextView text = (TextView)(R.id.textView1);

        //if(items.get(position) != null )

        if(text != null)
        {

            //text.setTextColor(Color.WHITE);
            text.setText(items[position]);
            //text.setBackgroundColor(Color.RED);
            //int color = Color.argb( 200, 255, 64, 64 );
            //text.setBackgroundColor( color );

        }

        return mView;
    }

}
