package com.example.testing.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import com.example.testing.myapplication.module.AAtest.TestFragment;
import com.example.testing.myapplication.module.keyBoard.KeyBoardActivity;

public class MainActivity extends AppCompatActivity {

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getSupportFragmentManager().beginTransaction()
        //    .add(android.R.id.content, new MainFragment(), "mainFragemnt")
        //    .commit();

        //getSupportFragmentManager().beginTransaction().add(new RetrofitFragment(), "retrofit").commit();
        //okHttp();

        //getSupportFragmentManager().beginTransaction().add(new DoubleGridRecyclerViewFragment(), "retrofit").commit();

        //getSupportFragmentManager().beginTransaction()
        //        .replace(android.R.id.content, getFragment(), "mainFragemnt")
        //        .commit();
        //
        //
        //PromptDialogFragment promptDialogFragment = new PromptDialogFragment();
        //
        //getSupportFragmentManager().beginTransaction()
        //        .add(promptDialogFragment, "prompt")
        //        .commitAllowingStateLoss();

    }


    private Fragment getFragment() {
        return
                //new DoubleGridRecyclerViewFragment(),
                //new RandomColorFragment(),
                //new TabFragment(),
                //new StickyHeaderFragment()
                //new RecyclerViewFragment()

                //new FastScrollFragment()

                //new AnimatorFragment()


                //new ItemAnimatorFragment()
                //new GsonDeepLearnFragment()

                //new PtrPageFragment()

                //new BadgeViewFragment()

                //new ServiceFragment()


                //new CustomViewFragment()


                new TestFragment()

                ;
    }

    public void onClick(View view) {
        Toast.makeText(this, "点击了", Toast.LENGTH_SHORT)
                .show();

        startActivity(new Intent(this, KeyBoardActivity.class));
    }

    private void okHttp() {
        //String url = "https://api.github.com/users/baiiu";
        //OkHttpUtils.get().url(url).build().execute(new StringCallback() {
        //  @Override public void onError(Call call, Exception e) {
        //    LogUtil.d(e.toString());
        //  }
        //
        //  @Override public void onResponse(String response) {
        //    LogUtil.d(response);
        //  }
        //});
    }
}
