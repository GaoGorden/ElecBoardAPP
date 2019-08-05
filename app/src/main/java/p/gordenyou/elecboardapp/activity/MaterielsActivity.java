package p.gordenyou.elecboardapp.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import p.gordenyou.elecboardapp.R;
import p.gordenyou.elecboardapp.adapter.FragmentAdapter;
import p.gordenyou.elecboardapp.fragment.Material.BarFragment;
import p.gordenyou.elecboardapp.fragment.Material.PieFragment;
import p.gordenyou.elecboardapp.fragment.Material.TableFragment;

public class MaterielsActivity extends AppCompatActivity {
    private ViewPager mViewpager;
    private BottomNavigationView bottomNavigationView;
    private static final String TAG = "MainActivity";
    private MenuItem mMenuitem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_materials);
        mViewpager = findViewById(R.id.materials_viewpager);
        bottomNavigationView = findViewById(R.id.materials_top);
//        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        BottomNavigationMenuView menuView = (BottomNavigationMenuView) bottomNavigationView.getChildAt(0);
        for (int i = 0; i < menuView.getChildCount(); i++) {
            final View iconView = menuView.getChildAt(i).findViewById(android.support.design.R.id.icon);
            final ViewGroup.LayoutParams layoutParams = iconView.getLayoutParams();
            final DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            layoutParams.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 0, displayMetrics);
            layoutParams.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 0, displayMetrics);
            iconView.setLayoutParams(layoutParams);
        }

        android.support.v4.app.FragmentManager fg = getSupportFragmentManager();
        List<Fragment> list = new ArrayList<>();
        PieFragment pieFragment = new PieFragment();
        BarFragment barFragment = new BarFragment();
        TableFragment tableFragment = new TableFragment();


        list.add(pieFragment);
        list.add(barFragment);
        list.add(tableFragment);



        final FragmentAdapter fragmentAdapter = new FragmentAdapter(fg, list);
        mViewpager.setAdapter(fragmentAdapter);

        mViewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {

                mMenuitem = bottomNavigationView.getMenu().getItem(position);
                mMenuitem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Log.d(TAG, "onNavigationItemSelected: " + item.getItemId());
                int fragmentid = 0;
                switch (item.getItemId()) {
                    case R.id.menu_materials_pie:
                        fragmentid = 0;
                        break;
                    case R.id.menu_materials_bar:
                        fragmentid = 1;
                        break;
                    case R.id.menu_materials_table:
                        fragmentid = 2;
                        break;
                }
                mViewpager.setCurrentItem(fragmentid);
                return true;
            }
        });
    }
}
