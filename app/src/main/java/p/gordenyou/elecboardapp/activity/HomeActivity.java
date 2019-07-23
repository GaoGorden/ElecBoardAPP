package p.gordenyou.elecboardapp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import p.gordenyou.elecboardapp.R;
import p.gordenyou.elecboardapp.adapter.FragmentAdapter;
import p.gordenyou.elecboardapp.fragment.MainFragment;


public class HomeActivity extends AppCompatActivity {
    private ViewPager mViewpager;
//    private BottomNavigationView mBottom;
    private static final String TAG = "MainActivity";
//    private MenuItem mMenuitem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        mViewpager = findViewById(R.id.main_viewpager);
//        mBottom = findViewById(R.id.main_bottom);
//        BottomNavigationViewHelper.disableShiftMode(mBottom);

        android.support.v4.app.FragmentManager fg = getSupportFragmentManager();
        List<Fragment> list = new ArrayList<>();
        MainFragment mainfragment = new MainFragment();
//        MessageFragment messageFragment = new MessageFragment();
//        PostFragment postFragment = new PostFragment();
//        UserFragment userFragment = new UserFragment();

        list.add(mainfragment);
//        list.add(messageFragment);
//        list.add(postFragment);
//        list.add(userFragment);


        final FragmentAdapter fragmentAdapter = new FragmentAdapter(fg, list);
        mViewpager.setAdapter(fragmentAdapter);

        mViewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {

//                mMenuitem = mBottom.getMenu().getItem(position);
//                mMenuitem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

//        mBottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                Log.d(TAG, "onNavigationItemSelected: " + item.getItemId());
//                int fragmentid = 0;
//                switch (item.getItemId()) {
//                    case R.id.item_plan:
//                        fragmentid = 0;
//                        break;
//                    case R.id.item_message:
//                        fragmentid = 1;
//                        break;
//                    case R.id.item_post:
//                        fragmentid = 2;
//                        break;
//                    case R.id.item_user:
//                        fragmentid = 3;
//                        break;
//                }
//                mViewpager.setCurrentItem(fragmentid);
//                return true;
//            }
//        });
    }

}
