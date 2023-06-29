package com.example.ungdungdoctruyen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ungdungdoctruyen.R;
import com.example.ungdungdoctruyen.model.chuyenmuc;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

public class adapterchuyenmuc extends BaseAdapter {
    private Context context;
    private int layout;
    private List<chuyenmuc> chuyenmucList;

    public adapterchuyenmuc(Context context, int layout, List<chuyenmuc> chuyenmucList) {
        this.context = context;
        this.layout = layout;
        this.chuyenmucList = chuyenmucList;
    }

    @Override
    public int getCount() {
        return chuyenmucList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        LayoutInflater inflater  =  (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);
        ImageView img = (ImageView) convertView.findViewById(R.id.imgchuyenmuc);
        TextView txt = (TextView) convertView.findViewById(R.id.textviewTenchuyenmuc);
        chuyenmuc cm = chuyenmucList.get(i);
        txt.setText(cm.getTenchuyenmuc());
        img.setImageResource(cm.getHinhanhchuyenmuc());
        return convertView;
    }
}
