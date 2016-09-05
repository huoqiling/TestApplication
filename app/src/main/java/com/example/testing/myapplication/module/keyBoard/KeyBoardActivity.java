package com.example.testing.myapplication.module.keyBoard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import cn.dreamtobe.kpswitch.util.KPSwitchConflictUtil;
import cn.dreamtobe.kpswitch.util.KeyboardUtil;
import cn.dreamtobe.kpswitch.widget.KPSwitchPanelLinearLayout;
import com.example.testing.myapplication.R;
import com.example.testing.myapplication.module.loadmoreRecyclerView.SimpleTextAdapter;
import com.example.testing.myapplication.util.LogUtil;

public class KeyBoardActivity extends AppCompatActivity {
    private RecyclerView mContentRyv;
    private EditText mSendEdt;
    private KPSwitchPanelLinearLayout mPanelRoot;
    private TextView mSendImgTv;
    private ImageView mPlusIv;
    private SimpleTextAdapter mAdapter;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_key_board);

        mContentRyv = (RecyclerView) findViewById(R.id.content_ryv);
        mSendEdt = (EditText) findViewById(R.id.send_edt);
        mPanelRoot = (KPSwitchPanelLinearLayout) findViewById(R.id.panel_root);
        mSendImgTv = (TextView) findViewById(R.id.send_img_tv);
        mPlusIv = (ImageView) findViewById(R.id.plus_iv);

        mContentRyv.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new SimpleTextAdapter(this, 20);
        mContentRyv.setAdapter(mAdapter);
        scrollToLast();

        initKeyBoard();



        mContentRyv.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override public void onGlobalLayout() {

            }
        });
    }

    public void scrollToLast() {
        mContentRyv.scrollToPosition(mAdapter.getItemCount() - 1);
    }

    public void hidePanelAndKeyboard() {
        mContentRyv.postDelayed(new Runnable() {
            @Override public void run() {
                KPSwitchConflictUtil.hidePanelAndKeyboard(mPanelRoot);
            }
        }, 100);

    }

    private void initKeyBoard() {
        KeyboardUtil.attach(this, mPanelRoot,
                            // Add keyboard showing state callback, do like this when you want to listen in the
                            // keyboard's show/hide change.
                            new KeyboardUtil.OnKeyboardShowingListener() {
                                @Override public void onKeyboardShowing(boolean isShowing) {
                                    LogUtil.d(String.format("Keyboard is %s", isShowing ? "showing" : "hiding"));
                                    scrollToLast();
                                }
                            });


        KPSwitchConflictUtil.attach(mPanelRoot, mPlusIv, mSendEdt, new KPSwitchConflictUtil.SwitchClickListener() {
            @Override public void onClickSwitch(boolean switchToPanel) {
                if (switchToPanel) {
                    mSendEdt.clearFocus();
                    scrollToLast();
                } else {
                    mSendEdt.requestFocus();
                }
            }
        });

        mSendImgTv.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Toast.makeText(KeyBoardActivity.this, "发送", Toast.LENGTH_SHORT)
                        .show();
            }
        });


        mContentRyv.setOnTouchListener(new View.OnTouchListener() {
            @Override public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    hidePanelAndKeyboard();
                }

                return false;
            }
        });
    }

    @Override public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_UP && event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            if (mPanelRoot.getVisibility() == View.VISIBLE) {
                hidePanelAndKeyboard();
                return true;
            }
        }
        return super.dispatchKeyEvent(event);
    }

}
