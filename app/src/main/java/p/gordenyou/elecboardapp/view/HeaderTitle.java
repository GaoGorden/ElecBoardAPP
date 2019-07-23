package p.gordenyou.elecboardapp.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import p.gordenyou.elecboardapp.R;


/**
 * Created by Gordenyou on 2018/3/15.
 */

public class HeaderTitle extends LinearLayout {
    private TextView textView;
    private Button rightbutton;
    private Button leftbutton;
    public HeaderTitle(Context context) {
        this(context, null);
    }

    public HeaderTitle(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HeaderTitle(final Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.view_headertitle,this);
        textView = view.findViewById(R.id.header_title);
        rightbutton = view.findViewById(R.id.header_rightbutton);
        leftbutton = view.findViewById(R.id.header_leftbutton);
        leftbutton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Activity) getContext()).finish();
            }
        });
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.HeaderTitle);
        textView.setText(a.getText(R.styleable.HeaderTitle_headertitle));
        rightbutton.setText(a.getText(R.styleable.HeaderTitle_headerbuttonname));
        if(a.getBoolean(R.styleable.HeaderTitle_headerbuttonvisable, true)){
            rightbutton.setVisibility(VISIBLE);
        }else{
            rightbutton.setVisibility(GONE);
        }
        a.recycle();
    }

    public String getHeadertitle(){
        return textView.getText().toString();
    }

    public Button getRightbutton(){
        return rightbutton;
    }
}
