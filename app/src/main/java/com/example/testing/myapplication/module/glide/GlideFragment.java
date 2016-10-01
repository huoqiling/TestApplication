package com.example.testing.myapplication.module.glide;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.example.testing.myapplication.R;
import com.example.testing.myapplication.util.LogUtil;

/**
 * auther: baiiu
 * time: 16/10/1 01 11:34
 * description:
 */

public class GlideFragment extends Fragment implements View.OnClickListener {

    private static final String url = "http://ww4.sinaimg.cn/large/610dc034jw1f8bc5c5n4nj20u00irgn8.jpg";
    private static final int FILE_SELECT_CODE = 1024;

    private ImageView imageView;

    @Nullable @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_glide, container, false);
        imageView = (ImageView) view.findViewById(R.id.imageView);
        view.findViewById(R.id.button)
                .setOnClickListener(this);
        return view;
    }

    @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Glide.with(this)
                .load(url)
                .asBitmap()
                .toBytes()
                .into(new SimpleTarget<byte[]>(250, 250) {
                    @Override
                    public void onResourceReady(byte[] resource, GlideAnimation<? super byte[]> glideAnimation) {
                        Bitmap bitmap = BitmapFactory.decodeByteArray(resource, 0, resource.length);
                        imageView.setImageBitmap(bitmap);
                    }
                });
    }

    @Override public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        try {
            startActivityForResult(Intent.createChooser(intent, "请选择一个要上传的PDF文件"), FILE_SELECT_CODE);
        } catch (android.content.ActivityNotFoundException ex) {
        }
    }

    @Override public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        LogUtil.d(data.toString());
        LogUtil.d(data.getDataString());
        Uri uri = data.getData();

        Glide.with(this)
                .load(uri)
                .listener(new RequestListener<Uri, GlideDrawable>() {
                    @Override public boolean onException(Exception e, Uri model, Target<GlideDrawable> target,
                            boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, Uri model, Target<GlideDrawable> target,
                            boolean isFromMemoryCache, boolean isFirstResource) {
                        LogUtil.d("okok");
                        return false;
                    }
                })
                .into(new GlideDrawableImageViewTarget(imageView) {
                    @Override public void onResourceReady(GlideDrawable resource,
                            GlideAnimation<? super GlideDrawable> animation) {
                        super.onResourceReady(resource, animation);
                        LogUtil.d("ok");
                    }
                });
        //Glide.with(this)
        //        .load(uri)
        //        .into(new SimpleTarget<GlideDrawable>() {
        //            @Override public void onResourceReady(GlideDrawable resource,
        //                    GlideAnimation<? super GlideDrawable> glideAnimation) {
        //                imageView.setImageDrawable(resource);
        //            }
        //        });

    }
}
