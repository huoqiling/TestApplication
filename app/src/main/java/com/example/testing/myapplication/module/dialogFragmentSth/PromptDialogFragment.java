package com.example.testing.myapplication.module.dialogFragmentSth;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.testing.myapplication.R;

/**
 * author: baiiu
 * date: on 16/9/8 16:02
 * description:
 */
public class PromptDialogFragment extends DialogFragment {
    @Override public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_TITLE, R.style.AlertDialogStyle_Prompt);
    }

    @Nullable @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_highlight, container, false);

        return view;
    }


    @Override public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //WindowManager.LayoutParams params = getDialog().getWindow()
        //        .getAttributes();
        //params.width = -2;
        //params.height = -2;

    }
}
