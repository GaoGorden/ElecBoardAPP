package tableLayout;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Smartown on 2017/7/19.
 */
public class TableColumn extends LinearLayout {

    private String[] content;
    private Callback callback;
    private float maxTextViewWidth;
    private String barcode;

    //构造函数，需要上下文，内容，和回调接口
    public TableColumn(Context context, String[] content, Callback callback) {
        super(context);
        this.content = content;
        this.callback = callback;
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension((int) (callback.getTableLayout().getTableColumnPadding() * 2 + maxTextViewWidth)
                , callback.getTableLayout().getTableRowHeight() * getChildCount());
    }

    private void init() {
        Log.i("TableColumn", "init");
        setOrientation(VERTICAL);

        initContent();
    }

    private void initContent() {
        int padding = callback.getTableLayout().getTableColumnPadding();
        maxTextViewWidth = 0;
        //将textview一个个放入arraylist中。
        ArrayList<TextView> textViews = new ArrayList<>();
        //判断每项内容是否为空
        for (String text : content) {
            if (TextUtils.isEmpty(text)) {
                text = "";
            }
            TextView textView = new TextView(getContext());
            textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, callback.getTableLayout().getTableTextSize());
            textView.setTextColor(callback.getTableLayout().getTableTextColor());
            maxTextViewWidth = Math.max(maxTextViewWidth, Util.measureTextViewWidth(textView, text));
            textView.setGravity(getTextGravity(callback.getTableLayout().getTableTextGravity()));
            textView.setPadding(padding, 0, padding, 0);
            textView.setText(text);
            textViews.add(textView);
        }
        LayoutParams layoutParams = new LayoutParams((int) (padding * 2 + maxTextViewWidth), callback.getTableLayout().getTableRowHeight());
        for (TextView textView : textViews) {
            if ((textViews.indexOf(textView) ==0))//将第一行设为标题行
                textView.setTextColor(callback.getTableLayout().getHeaderColor());
            addView(textView, layoutParams);
        }
    }

    private int getTextGravity(int tableTextGravity) {
        switch (tableTextGravity) {
            case 1:
                return Gravity.CENTER_VERTICAL;
            case 2:
                return Gravity.CENTER_VERTICAL | Gravity.RIGHT;
        }
        return Gravity.CENTER;
    }

    public void onClick(float y) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            TextView textView = (TextView) getChildAt(i);
            if (textView.getBottom() >= y) {
                if (i == 0) {
                    return;
                }
                barcode = textView.getText().toString();
                textView.setSelected(!textView.isSelected());
                textView.setBackgroundColor(textView.isSelected() ? callback.getTableLayout().getBackgroundColorSelected() : Color.TRANSPARENT);
                textView.setTextColor(textView.isSelected() ? callback.getTableLayout().getTableTextColorSelected() : callback.getTableLayout().getTableTextColor());
                return;
            }
        }
    }

    public String getBarcode() {
        return barcode;
    }

    public interface Callback {
        TableLayout getTableLayout();
    }

}
