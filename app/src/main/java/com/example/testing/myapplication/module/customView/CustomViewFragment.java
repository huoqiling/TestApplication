package com.example.testing.myapplication.module.customView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.testing.myapplication.R;
import java.util.ArrayList;
import java.util.List;

/**
 * author: baiiu
 * date: on 16/8/22 20:28
 * description:
 */
public class CustomViewFragment extends Fragment {

    @Nullable @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_custom_view, container, false);

        OneFrameLayout oneFrameLayout = (OneFrameLayout) view.findViewById(R.id.one_view);

        List<String> signs = new ArrayList<>();
        signs.add("标签1");
        signs.add("哈");
        signs.add("标签2");
        signs.add("哈哈哈哈哈哈哈哈哈哈哈");
        signs.add("标签3");
        signs.add("哈哈哈");
        signs.add("标签4");
        signs.add("哈");


        oneFrameLayout.setListSigns("名字开头", signs, true);


        return view;
    }
}
