package co.sanfen.android.androidinterview.activity.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.ListFragment;

import java.util.List;

/**
 * @author MZ
 * @email sanfenruxi1@163.com
 * @date 2018/4/19.
 */

public class MyFragmentAdapter extends FragmentPagerAdapter {
    List<Fragment> list;

    public MyFragmentAdapter(FragmentManager fm, List<Fragment> listFragment) {
        super(fm);
        this.list = listFragment;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
