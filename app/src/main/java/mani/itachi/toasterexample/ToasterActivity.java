package mani.itachi.toasterexample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

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
                Toaster.makeText(this, "Hi! This is a sample toast").show();
                break;
            case R.id.normal_icon:
                Toaster.makeText(this, "A toast with a cute cat").setIcon(R.drawable.cat).show();
                break;
            case R.id.error:
                Toaster.error(this, "Oops! Error occurred").show();
                break;
            case R.id.info:
                Toaster.info(this, "Hey, here is some info").show();
                break;
            case R.id.success:
                Toaster.success(this, "Yay, it's  a success").show();
                break;
            case R.id.customConfig:
                Toaster.custom(this, "This <b>CAT</b> looks too <i>cute</i>", R.drawable.cat,
                        Color.parseColor("#FFA900"), Color.parseColor("#000000"),
                        Toast.LENGTH_LONG, true, true, Toaster.MONOSPACE, false, -1, -1, -1)
                        .show();
                break;
            case R.id.center:
                Toaster.makeText(this, "Wow! I am at the center of screen")
                        .setGravity(Gravity.CENTER, 0, 0)
                        .show();
                break;
            case R.id.top:
                Toaster.makeText(this, "I am afraid of heights")
                        .setGravity(Gravity.TOP, 0, 64)
                        .show();
                break;
        }
    }

}
