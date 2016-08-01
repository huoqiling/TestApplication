package com.example.testing.myapplication.module.ptrPage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.example.testing.myapplication.R;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * auther: baiiu
 * time: 16/8/1 01 22:13
 * description:
 */
public class PtrPageFragment extends Fragment {


    private PtrClassicFrameLayout ptr;
    private TextView textView;

    @Nullable @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_ptr, container, false);

        ptr = (PtrClassicFrameLayout) view.findViewById(R.id.ptr);
        textView = (TextView) view.findViewById(R.id.textView);

        ptr.postDelayed(new Runnable() {
            @Override public void run() {
                ptr.autoRefresh();
            }
        }, 500);

        //ptr.setPullToRefresh(true);//下拉即开始刷新,不释放刷新
        //ptr.setKeepHeaderWhenRefresh(false);//刷新时不保持头部

        //ptr.setEnabledNextPtrAtOnce(true);//刷新完成后头部还未完全收回,再次下拉,又可刷新
        //ptr.setPinContent(true);//内容位置不变,仅头部下拉
        //ptr.disableWhenHorizontalMove(true);//ViewPager滑动冲突时打开,Ptr内部包含了个ViewPager

        //ptr.setLoadingMinTime(2000);//刷新头部至少保持2秒
        //ptr.setResistance(5);//阻尼系数,越大越吃力
        //ptr.setRatioOfHeaderHeightToRefresh(2);//触发刷新时移动的位置比例,2表示移动了2倍当前刷新头部距离才触发刷新
        //ptr.setDurationToCloseHeader(3000);//头部回弹时间,当前下拉高度已经到达了头部View高度.该头部回弹时间
        //ptr.setDurationToClose(3000);//回弹到刷新高度所用时间,当前下拉高度大于头部View高度,回弹到仅剩下头部View高度所需时间


        /*
            自定义Header时,实现PtrUIHandler接口.
            ptr.setHeaderView(header);
            ptr.addPtrUIHandler(header);
         */

        textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override public boolean onLongClick(View v) {
                Toast.makeText(getContext(), "长按了", Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });


        ptr.setPtrHandler(new PtrDefaultHandler() {
            @Override public void onRefreshBegin(final PtrFrameLayout frame) {
                frame.postDelayed(new Runnable() {
                    @Override public void run() {
                        frame.refreshComplete();
                        textView.setText("done");
                    }
                }, 1000);
            }

            @Override public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return super.checkCanDoRefresh(frame, content, header);
                //return false;不能下拉,autoRefresh依然有效
            }
        });


        return view;
    }
}
