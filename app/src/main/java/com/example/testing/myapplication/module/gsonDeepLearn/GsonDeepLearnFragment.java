package com.example.testing.myapplication.module.gsonDeepLearn;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.testing.myapplication.R;
import com.example.testing.myapplication.module.gsonDeepLearn.bean.Person;
import com.example.testing.myapplication.util.LogUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * auther: baiiu
 * time: 16/7/16 16 18:32
 * description:
 */
public class GsonDeepLearnFragment extends Fragment {

    @Nullable @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_common, container, false);
    }

    @Override public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Person person = new Person();
        person.name = "小明";
        person.age = 24;
        person.sex = true;
        Gson gson = new GsonBuilder().setPrettyPrinting()
                .create();

        String s = gson.toJson(person);
        LogUtil.d(s);
    }

}
