package com.example.testing.myapplication.module.itemAnimator;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import java.util.List;

/**
 * author: baiiu
 * date: on 16/7/8 11:04
 * description:
 *
 * 具体使用可查看该文章:
 * <a href="http://blog.csdn.net/zxm317122667/article/details/51502377">RecyclerView.ItemAnimator(三)--继承DefaultItemAnimator实现自定义动画</a>
 */
public class USimpleItemAnimator extends SimpleItemAnimator {

    @Override public boolean animateRemove(RecyclerView.ViewHolder holder) {
        return false;
    }

    @Override public boolean animateAdd(RecyclerView.ViewHolder holder) {
        return false;
    }

    @Override
    public boolean animateMove(RecyclerView.ViewHolder holder, int fromX, int fromY, int toX, int toY) {
        return false;
    }

    @Override
    public boolean animateChange(RecyclerView.ViewHolder oldHolder, RecyclerView.ViewHolder newHolder,
            int fromLeft, int fromTop, int toLeft, int toTop) {
        return false;
    }

    @Override public void runPendingAnimations() {

    }

    @Override public void endAnimation(RecyclerView.ViewHolder item) {

    }

    @Override public void endAnimations() {

    }

    @Override public boolean isRunning() {
        return false;
    }

    @NonNull @Override public ItemHolderInfo recordPreLayoutInformation(@NonNull RecyclerView.State state,
            @NonNull RecyclerView.ViewHolder viewHolder, int changeFlags, @NonNull List<Object> payloads) {
        /*
            Item animator should record
            necessary information about the View before it is potentially rebound, moved or removed.

            预先存储所需信息,返回
         */
        UItemHolderInfo itemHolderInfo =
                (UItemHolderInfo) super.recordPreLayoutInformation(state, viewHolder, changeFlags,
                                                                   payloads);

        //进行处理

        return itemHolderInfo;

    }

    @NonNull @Override public ItemHolderInfo recordPostLayoutInformation(@NonNull RecyclerView.State state,
            @NonNull RecyclerView.ViewHolder viewHolder) {
        /*
            Called by the RecyclerView after the layout is complete. Item animator should record
            necessary information about the View's final state.

            layout过程结束,已经计算出终点位置,返回
         */
        return super.recordPostLayoutInformation(state, viewHolder);
    }

    @Override public ItemHolderInfo obtainHolderInfo() {
        /*
            ItemHolderInfo是存储信息类,可以override
            It uses {@link ItemHolderInfo} to track the bounds information of the Views.
             If you would like to extend this class, you can override {@link #obtainHolderInfo()} method
             to provide your own info class that extends {@link ItemHolderInfo}.

             可以Override该方法获取自己的ItemHolderInfo
         */
        //return super.obtainHolderInfo();
        return new UItemHolderInfo();
    }

    //自己的ItemHolderInfo类,存储所需要的变化信息
    private class UItemHolderInfo extends ItemHolderInfo {

    }
}
