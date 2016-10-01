package keyBoard;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baiiu.ptr.R;

/**
 * author: baiiu
 * date: on 16/6/27 17:38
 * description:
 */
public class SimpleTextViewHolder extends RecyclerView.ViewHolder {

    private final TextView textView;

    public SimpleTextViewHolder(Context context, ViewGroup parent) {
        super(LayoutInflater.from(context)
                      .inflate(R.layout.holder_simple, parent, false));

        itemView.setPadding(0, 100, 0, 100);
        textView = (TextView) itemView.findViewById(android.R.id.text1);
    }

    public void bind(int position) {

        textView.setText("position: " + String.valueOf(position));

        if (position % 2 == 0) {
            itemView.setBackgroundResource(android.R.color.darker_gray);
        } else {
            itemView.setBackgroundResource(android.R.color.background_light);
        }
    }

    public void bind(String text) {
        ((TextView) itemView).setText(text);
    }

}
