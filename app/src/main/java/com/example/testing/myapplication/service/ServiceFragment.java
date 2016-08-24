package com.example.testing.myapplication.service;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.testing.myapplication.R;

/**
 * author: baiiu
 * date: on 16/8/15 17:45
 * description:
 */
public class ServiceFragment extends Fragment implements View.OnClickListener {

    @Nullable @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_service, container, false);
        view.findViewById(R.id.start)
                .setOnClickListener(this);
        view.findViewById(R.id.stop)
                .setOnClickListener(this);


        return view;
    }

    @Override public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start:
                //getActivity().startService(new Intent(getContext(), MyService.class));
                TestIntentService.startActionBaz(getContext());
                getActivity().startService(new Intent(getContext(), TestIntentService.class));
                break;
            case R.id.stop:
                //getActivity().stopService(new Intent(getContext(), MyService.class));
                getActivity().stopService(new Intent(getContext(), TestIntentService.class));
                break;
        }
    }
}
