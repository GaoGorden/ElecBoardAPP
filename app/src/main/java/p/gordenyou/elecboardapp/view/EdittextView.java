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

import p.gordenyou.elecboardapp.R;


/**
 * Created by Gordenyou on 2018/3/5.
 */

public class EdittextView extends LinearLayout {
    private TextView title;
    private EditText editText;
    public EdittextView(Context context) {
        this(context, null);
    }

    public EdittextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public EdittextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.view_edittext, this);
        title = (TextView) view.findViewById(R.id.et_title);
        editText = (EditText) view.findViewById(R.id.et_edittext);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.EdittextView);
        title.setText(a.getText(R.styleable.EdittextView_edittexttitle));
        editText.setHint(a.getText(R.styleable.EdittextView_edittexthint));
        a.recycle();
    }

    public EditText getEditText(){
        return editText;
    }

    public String getText(){
        return editText.getText().toString().trim();
    }
}
