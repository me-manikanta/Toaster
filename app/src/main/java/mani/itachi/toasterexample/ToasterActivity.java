package mani.itachi.toasterexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;

import mani.itachi.toaster.Toaster;

public class ToasterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toaster);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.normal:
                Toaster.makeText(this, "Normal Toast").show();
                break;
            case R.id.normal_icon:
                Toaster.makeText(this,"Normal Toast with Icon").setIcon(R.drawable.ic_launcher).show();
                break;
            case R.id.error:
                Toaster.error(this,"Error Toast").show();
                break;
            case R.id.info:
                Toaster.info(this,"Info Toast on Top").setGravity(Gravity.CENTER,0,0).show();
                break;
            case R.id.succes:
                Toaster.success(this,"Success Toast on Center").setGravity(Gravity.TOP,0,0).show();
                break;
        }
    }

}
