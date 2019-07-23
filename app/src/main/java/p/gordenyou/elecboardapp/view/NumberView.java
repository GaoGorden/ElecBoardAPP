package p.gordenyou.elecboardapp.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import p.gordenyou.elecboardapp.R;


/**
 * Created by Gordenyou on 2018/3/8.
 */

public class NumberView extends LinearLayout {
    @BindView(R.id.number_title)
    TextView title;
    @BindView(R.id.number_content)
    EditText content;

    int defultnumber;
    public NumberView(Context context) {
        this(context, null);
    }

    public NumberView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NumberView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.view_number, this);
        ButterKnife.bind(view);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.NumberView);
        title.setText(a.getText(R.styleable.NumberView_numbertitle));
        defultnumber = Integer.parseInt(a.getText(R.styleable.NumberView_numberdefult).toString());
        content.setHint(a.getText(R.styleable.NumberView_numberhint));
        a.recycle();
    }

    public EditText getEdittext(){
        return content;
    }

    public int getNumber(){
        if(!content.getText().toString().equals("")){
            return Integer.parseInt(content.getText().toString());
        }else {
            return defultnumber;
        }
    }
}
