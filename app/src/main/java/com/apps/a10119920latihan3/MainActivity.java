package com.apps.a10119920latihan3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.Window;
import android.view.WindowManager;
import butterknife.ButterKnife;
import butterknife.OnClick;
import static com.apps.a10119920latihan3.DoneActivity.ID_EXTRA_MSG_EXIT;

/**
 * Tanggal  : 05 MEI 2022
 * NAMA     : UMAR SAID ADI PRANOTO
 * NIM      : 10119920
 * KELAS    : IF10
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_welcome);

        ButterKnife.bind(this);

        if (getIntent().getBooleanExtra(ID_EXTRA_MSG_EXIT, false)) {
            finish();
        }
    }

    @OnClick(R.id.btn_mulai)
    void mulai() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}