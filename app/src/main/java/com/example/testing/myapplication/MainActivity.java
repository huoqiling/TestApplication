package com.example.testing.myapplication;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.example.testing.myapplication.bean.Sign;
import com.example.testing.myapplication.module.itemDecoration.ItemDecorationFragment;
import com.example.testing.myapplication.util.LogUtil;
import com.example.testing.myapplication.view.NameTagsLinearViewGroup;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv_test = (TextView) findViewById(R.id.tv_test);

        GradientDrawable drawable = (GradientDrawable) getResources().getDrawable(R.drawable.rect_rudis);
        drawable.setStroke(3, getResources().getColor(R.color.colorPrimary));
        tv_test.setBackgroundDrawable(drawable);

        //String s = "<font colot='#FF969FA9' size='1000'>哈哈哈哈</font>"
        //        + " <font color='#FF5a626d'><strong>"
        //        + "6666"
        //        + "</strong></font> "
        //        + "<font "
        //        + "colot='#FF969FA9'>哈哈哈哈</font>";
        //Spanned spanned = Html.fromHtml(s);
        //tv_test.setText(spanned);
        //tv_test.setBackgroundDrawable(new RoundDrawable(getResources().getColor(R.color.colorAccent), 2, true));

        //drawable.setPadding(new Rect(4, 4, 4, 4));
        //drawable.setShape(Shape s);


        NameTagsLinearViewGroup viewGroup = (NameTagsLinearViewGroup) findViewById(R.id.nameTagsLinearViewGroup);

        List<Sign> list = new ArrayList<>();
        for (int i = 0; i < 3; ++i) {
            list.add(new Sign("#123456", "哈哈" + i));
        }
        LogUtil.d(list.size());

        String name = "你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好";
        viewGroup.setListSigns(name, list);


        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, getFragment(), "mainFragemnt")
                .commit();


        //getSupportFragmentManager().beginTransaction()
        //    .add(android.R.id.content, new MainFragment(), "mainFragemnt")
        //    .commit();

        //getSupportFragmentManager().beginTransaction()
        //        .add(new RetrofitFragment(), "retrofit")
        //        .commit();
        //okHttp();

        //getSupportFragmentManager().beginTransaction().add(new DoubleGridRecyclerViewFragment(), "retrofit").commit();


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


                //new TestFragment()

                //new HighLightFragment()

                new ItemDecorationFragment()


                ;
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
