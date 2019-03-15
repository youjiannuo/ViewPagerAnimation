package com.app.myapplicationtest;

import android.view.View;

import com.yn.framework.activity.Layout;
import com.yn.framework.activity.TopBar;
import com.yn.framework.activity.YNAutomaticActivity;
import com.yn.framework.system.SystemUtil;
import com.yn.framework.view.YNFragmentStateClassPageAdapter;
import com.yn.framework.view.YNViewPager;

import static java.lang.String.valueOf;

@Layout(
        layoutId = R.layout.activity_main
)
@TopBar(
        titleResourceId = R.string.app_name,
        rightButtonResourceId = R.drawable.loading
)
public class MainActivity extends YNAutomaticActivity {

    private YNViewPager mViewPager;
    private View mLayout;


    @Override
    protected void initView() {
        super.initView();
        mViewPager = findViewById(R.id.viewPage1);
        mLayout = findViewById(R.id.a1);
    }

    @Override
    protected void setViewData() {
        super.setViewData();
        final YNFragmentStateClassPageAdapter<Fragment1>
                adapter = new YNFragmentStateClassPageAdapter<Fragment1>(getSupportFragmentManager()) {
            @Override
            public Object getFragmentClass() {
                return new Class[]{Fragment1.class, Fragment1.class, Fragment1.class, Fragment1.class};
            }

            @Override
            public void setData(Fragment1 fragment, int index) {

            }
        };
        mViewPager.setPageMargin(SystemUtil.dipTOpx(10));
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.invalidate();
        mViewPager.setAdapter(adapter);
        mViewPager.setOnScrollerListener(new YNViewPager.OnScrollerListener() {
            @Override
            public void onScroller(float ratio, int from, int to) {
                SystemUtil.printlnInfo("ratio = %s , from = %s , to = %s", valueOf(ratio), valueOf(from), valueOf(to));
                Fragment1 fromFragment = (Fragment1) adapter.getBaseFragment(from);
                Fragment1 toFragment = (Fragment1) adapter.getBaseFragment(to);
                if (from < to && from - 1 >= 0) {
                    Fragment1 fragment1 = (Fragment1) adapter.getBaseFragment(from - 1);
                    fragment1.changeSize(1 - ratio);
                } else if (from > to) {
                    Fragment1 fragment1 = (Fragment1) adapter.getBaseFragment(from + 1);
                    if (fragment1 != null) {
                        fragment1.changeSize(1 - ratio);
                    }
                }
                toFragment.changeSize(1 - ratio);
                fromFragment.changeSize(ratio);
                mLayout.invalidate();
            }

            @Override
            public void onSelect(int position) {

            }
        });
    }
}
