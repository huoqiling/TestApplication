package com.baiiu.ptr;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.baiiu.ptr.ultraPtrPage.PtrPageFragment;
import keyBoard.KeyBoardActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(android.R.id.content, getFragment(), "mainFragemnt")
                .addToBackStack(null)
                .commit();

    }

    public Fragment getFragment() {


        return


                new PtrPageFragment();

    }

    @Override public void onClick(View view) {
        switch (view.getId()) {
            case R.id.keyboard:
                startActivity(new Intent(this, KeyBoardActivity.class));
                break;
        }
        
    }
}
