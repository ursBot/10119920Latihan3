package com.apps.a10119920latihan3;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Tanggal  : 05 MEI 2022
 * NAMA     : UMAR SAID ADI PRANOTO
 * NIM      : 10119920
 * KELAS    : IF10
 */

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.txtCheckCodeAgree)
    TextView txtAgree;
    @BindView(R.id.edtInputCode)
    EditText edtInputCode;
    @BindString(R.string.check_code_warning_empty_title)
    String emptyTitle;
    @BindString(R.string.check_code_warning_empty_desc)
    String emptyMessage;
    @BindString(R.string.warning_title)
    String warningTitle;
    private String code;

    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        txtAgree.setText(Html.fromHtml(getString(R.string.check_code_text_agreement)));
    }

    @OnClick(R.id.btnCheckCode)
    public void masuk(View view) {
        code = edtInputCode.getText().toString();

        if (isStringEmpty(code)) {
            showWarningMessage();
        } else {
            startActivity(new Intent(this, BiodataActivity.class));
        }
    }

    public static boolean isStringEmpty(String str) {
        return "".equals(str);
    }

    public void showWarningMessage(){
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.activity_warning_dialog);
        dialog.setTitle(warningTitle);

        TextView textTitle = (TextView) dialog.findViewById(R.id.txtWarningDialogTitle);
        TextView text = (TextView) dialog.findViewById(R.id.txtWarningDialogDesc);
        Button dialogButton = (Button) dialog.findViewById(R.id.btnWarningDialogOk);

        textTitle.setText(emptyTitle);
        text.setText(emptyMessage);

        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

}
