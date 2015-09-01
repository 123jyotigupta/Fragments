package com.example.android.fragmentexample;

import android.app.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by developeri on 9/1/15.
 */
public class TextFragment extends Fragment implements ToolBarListener{
    public static TextView textView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.text_fragment,
                container, false);
      textView = (TextView) view.findViewById(R.id.textView1);
        return view;
    }

    @Override
    public int onButtonClick(int position, String text) {
        changeTextProperties(position,text);
        return R.mipmap.ic_launcher;
    }

    public void changeTextProperties(int fontsize, String text)
    {
        textView.setTextSize(fontsize);
        textView.setText(text);
    }
}


