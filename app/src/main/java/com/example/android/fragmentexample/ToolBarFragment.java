package com.example.android.fragmentexample;


import android.app.Activity;
//
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

/**
 * Created by developeri on 9/1/15.
 */
public class ToolBarFragment extends Fragment implements OnSeekBarChangeListener {

    private static int seekvalue = 10;
    private static EditText editText;
    private ImageView imageview;

    ToolBarListener activityCallback;
     public void setToolBar(ToolBarListener TB){
         activityCallback = TB;
     }
//    public interface ToolbarListener {
//        public void onButtonClick(int position, String text);
//    }

  //  @Override
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//        try {
//            activityCallback = (ToolbarListener) activity;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(activity.toString()
//                    + " must implement ToolbarListener");
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.toolbar_fragment,
                container, false);
        editText = (EditText) view.findViewById(R.id.editText1);
        final SeekBar seekbar =
                (SeekBar) view.findViewById(R.id.seekBar1);
                seekbar.setOnSeekBarChangeListener(this);

        final Button button =
                (Button) view.findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonClicked(v);
            }
        });

         imageview = (ImageView) view.findViewById(R.id.imageView);
        return view;

    }

    public void buttonClicked(View view) {

        imageview.setImageResource(activityCallback.onButtonClick(seekvalue,
                editText.getText().toString()));

    };

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress,
                                  boolean fromUser) {
        seekvalue = progress;
    }

    @Override
    public void onStartTrackingTouch(SeekBar arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onStopTrackingTouch(SeekBar arg0) {
        // TODO Auto-generated method stub
    }

}
