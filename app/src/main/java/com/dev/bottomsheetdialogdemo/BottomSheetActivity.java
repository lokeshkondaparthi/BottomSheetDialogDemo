package com.dev.bottomsheetdialogdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BottomSheetActivity extends AppCompatActivity {

    private TextView tvBottomSheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet);
        tvBottomSheet  = (TextView )findViewById(R.id.tv_bottom_sheet);
        tvBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TutsPlusBottomSheetDialogFragment fragment = new TutsPlusBottomSheetDialogFragment();
                fragment.show(getSupportFragmentManager(), fragment.getTag());
            }
        });
    }
}
