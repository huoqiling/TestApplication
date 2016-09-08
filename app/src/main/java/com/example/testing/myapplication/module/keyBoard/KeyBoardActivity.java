package com.example.testing.myapplication.module.keyBoard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import cn.dreamtobe.kpswitch.util.KPSwitchConflictUtil;
import cn.dreamtobe.kpswitch.util.KeyboardUtil;
import cn.dreamtobe.kpswitch.widget.KPSwitchPanelLinearLayout;
import com.example.testing.myapplication.R;
import com.example.testing.myapplication.module.loadmoreRecyclerView.SimpleTextAdapter;
import com.example.testing.myapplication.util.LogUtil;

public class KeyBoardActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private EditText mEditText;
    private KPSwitchPanelLinearLayout mPanelRoot;
    private TextView mPanelItem;
    private ImageView mPlusIv;
    private SimpleTextAdapter mAdapter;
    private ListView mListView;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_key_board);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mEditText = (EditText) findViewById(R.id.send_edt);
        mPanelRoot = (KPSwitchPanelLinearLayout) findViewById(R.id.panel_root);
        //适配高度
        mPanelRoot.setIgnoreRecommendHeight(true);




        mPanelItem = (TextView) findViewById(R.id.send_img_tv);
        mPlusIv = (ImageView) findViewById(R.id.plus_iv);
        mListView = (ListView) findViewById(R.id.listView);
        initKeyBoard();

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new SimpleTextAdapter(this, 20);
        mRecyclerView.setAdapter(mAdapter);
        mListView.setAdapter(new TextAdapter(this));




        scrollToLast();
    }

    public void scrollToLast() {
        mRecyclerView.scrollToPosition(mAdapter.getItemCount() - 1);
    }

    public void hidePanelAndKeyboard() {
        mRecyclerView.postDelayed(new Runnable() {
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


        KPSwitchConflictUtil.attach(mPanelRoot, mPlusIv, mEditText, new KPSwitchConflictUtil.SwitchClickListener() {
            @Override public void onClickSwitch(boolean switchToPanel) {
                if (switchToPanel) {
                    //show Panel Layout
                    mEditText.clearFocus();
                    scrollToLast();
                } else {
                    mEditText.requestFocus();
                }
            }
        });

        mPanelItem.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Toast.makeText(KeyBoardActivity.this, "发送", Toast.LENGTH_SHORT)
                        .show();

                mListView.setVisibility(View.VISIBLE);

            }
        });


        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_DRAGGING) {
                    hidePanelAndKeyboard();
                }
            }
        });

        //mRecyclerView.setOnTouchListener(new View.OnTouchListener() {
        //    @Override public boolean onTouch(View view, MotionEvent motionEvent) {
        //        if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
        //            hidePanelAndKeyboard();
        //        }
        //
        //        return false;
        //    }
        //});
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
