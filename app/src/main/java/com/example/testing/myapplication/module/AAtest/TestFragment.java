package com.example.testing.myapplication.module.AAtest;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.example.testing.myapplication.R;
import com.example.testing.myapplication.util.LogUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 * author: baiiu
 * date: on 16/8/23 18:48
 * description:
 */
public class TestFragment extends Fragment {

    private List<String> list;
    private List<String> toList;

    @Override public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        test();
    }

    @Nullable @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, container, false);
        TextView textView = (TextView) view.findViewById(R.id.textView);


        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.right_out);
        textView.startAnimation(animation);

        return view;
    }

    private void test() {
        list = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            list.add("item " + i);
        }

        toList = new ArrayList<>();


        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                toList.addAll(list);

                list.clear();

                LogUtil.d(toList.toString() + ", " + list.toString());
            }
        }, 1000);


        HashMap<String, List<String>> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("哈哈哈");
        list.add("呵呵呵");
        map.put("key", list);
        LogUtil.d(map.toString());


        Bundle bundle = new Bundle();
        bundle.putSerializable("bundle", map);

        StringUtils.join(list, ",");

    }
}
