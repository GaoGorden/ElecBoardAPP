package p.gordenyou.elecboardapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Gordenyou on 2018/1/4.
 */

public class FragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragment;

    public FragmentAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.mFragment = list;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragment.get(position);
    }

    @Override
    public int getCount() {
        return mFragment.size();
    }
}
