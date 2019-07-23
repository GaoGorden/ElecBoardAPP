package p.gordenyou.elecboardapp.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import p.gordenyou.elecboardapp.R;


/**
 * Created by Gordenyou on 2018/3/2.
 */

public class ScannerView extends LinearLayout {
    private EditText editText;
    private TextView textView;
    private Button button;

    public ScannerView(Context context) {
        this(context, null);
    }

    public ScannerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ScannerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.view_scanner, this);
        textView = view.findViewById(R.id.sc_title);
        editText = view.findViewById(R.id.sc_edittext);
        button = view.findViewById(R.id.sc_button);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ScannerView);
        textView.setText(a.getText(R.styleable.ScannerView_scannertitle));
        editText.setHint(a.getText(R.styleable.ScannerView_scannerhint));
        button.setText(a.getText(R.styleable.ScannerView_scannerbuttonname));
        if(a.getBoolean(R.styleable.ScannerView_buttonvisable, true)){
            button.setVisibility(VISIBLE);
        }else{
            button.setVisibility(GONE);
        }
        a.recycle();
    }

    public EditText getEditTextView() {
        return editText;
    }

    public Button getButton() {
        return button;
    }

    public String getText(){
        return editText.getText().toString().trim();
    }

    public void SetText(String text){
        editText.setText(text);
    }
}
