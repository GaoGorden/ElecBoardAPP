package p.gordenyou.elecboardapp.activity;

import android.app.Activity;
import android.os.Bundle;

import butterknife.BindView;
import butterknife.ButterKnife;
import p.gordenyou.elecboardapp.R;
import p.gordenyou.elecboardapp.view.View_PieChart;

public class MaterielsActivity extends Activity {

    @BindView(R.id.materials_view)
    View_PieChart radialGradientView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        radialGradientView = new PieChart02View(this);
        setContentView(R.layout.activity_materials);
        ButterKnife.bind(this);
    }
}
