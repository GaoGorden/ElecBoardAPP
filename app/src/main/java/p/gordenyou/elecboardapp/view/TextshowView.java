package p.gordenyou.elecboardapp.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import p.gordenyou.elecboardapp.R;


/**
 * Created by Gordenyou on 2018/3/8.
 */

public class TextshowView extends LinearLayout {
    @BindView(R.id.textshow_title)
    TextView title;
    @BindView(R.id.textshow_content)
    TextView content;
    public TextshowView(Context context) {
        this(context, null);
    }

    public TextshowView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TextshowView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.view_textshow, this);
        ButterKnife.bind(view);
        TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.TextshowView);
        title.setText(a.getText(R.styleable.TextshowView_textshowtitle));
        title.setHint(a.getText(R.styleable.TextshowView_textshowtitle));
        a.recycle();
    }

    public TextView getTextview(){
        return content;
    }

    public void SetText(String text){
        content.setText(text);
    }

    public String getText(){
        return content.getText().toString();
    }
}
