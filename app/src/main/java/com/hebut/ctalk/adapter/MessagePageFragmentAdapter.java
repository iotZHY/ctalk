package com.hebut.ctalk.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.hebut.ctalk.fragment.Inform;
import com.hebut.ctalk.fragment.SubMessage;

public class MessagePageFragmentAdapter extends FragmentPagerAdapter {

    private String[] mTitles = new String[]{"消息", "通知"};

    public MessagePageFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        System.out.println("abc+"+position);
        if (position == 0) {
            return new SubMessage();
        } else {
            return new Inform();
        }
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    //ViewPager与TabLayout绑定后，这里获取到PageTitle就是Tab的Text
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
