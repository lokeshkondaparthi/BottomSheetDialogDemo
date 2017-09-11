package com.dev.bottomsheetdialogdemo;

import android.app.Dialog;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.CoordinatorLayout;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/* This class has been taken from this site https://code.tutsplus.com/articles/how-to-use-bottom-sheets-with-the-design-support-library--cms-26031*/
public class TutsPlusBottomSheetDialogFragment extends BottomSheetDialogFragment {
 
    private BottomSheetBehavior.BottomSheetCallback mBottomSheetBehaviorCallback = new BottomSheetBehavior.BottomSheetCallback() {
 
        @Override
        public void onStateChanged(@NonNull View bottomSheet, int newState) {
            if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                dismiss();
            }
 
        }
 
        @Override
        public void onSlide(@NonNull View bottomSheet, float slideOffset) {
        }
    };
 
    @Override
    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);
        View contentView = View.inflate(getContext(), R.layout.content_main, null);
        dialog.setContentView(contentView);
        Button bthelloWorld  = contentView.findViewById(R.id.bt_hello_world);
        Button btHiWorld  = contentView.findViewById(R.id.bt_hi);
        bthelloWorld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Hello world clicked", Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });
        btHiWorld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Hi world clicked !", Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) ((View) contentView.getParent()).getLayoutParams();
        CoordinatorLayout.Behavior behavior = params.getBehavior();
 
        if( behavior != null && behavior instanceof BottomSheetBehavior ) {
            ((BottomSheetBehavior) behavior).setBottomSheetCallback(mBottomSheetBehaviorCallback);
        }
    }
}