package com.example.demobindlife;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        // Example of a call to a native method

    }

    public void test_BindLife (View mView) {
        Intent mIntent = null;
        switch (mView.getId ()) {
            case R.id.bindV4_Activity_Fragement:
                mIntent = new Intent (this, DemoBindLifeActivityV4.class);
                break;
            case R.id.bind_Activity_Fragement:
                mIntent = new Intent (this, DemoBindLifeActivity.class);
                break;
        }
        startActivity (mIntent);

    }

}
