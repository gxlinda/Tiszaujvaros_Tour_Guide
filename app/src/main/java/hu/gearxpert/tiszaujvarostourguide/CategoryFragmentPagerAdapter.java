package hu.gearxpert.tiszaujvarostourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by melinda.kostenszki on 2017.05.09..
 */

public class CategoryFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public CategoryFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new RestaurantsFragment();
        } else if (position == 1) {
            return new BarsFragment();
        } else if (position == 2) {
            return new ShopsFragment();
        } else {
            return new HotelsFragment();
        }
    }

    @Override
    public int getCount() { //annyi a return érték, ahány Fragmentem van. Ha kevesebbet írok, akkor az utolsó(k) nem jelenik meg.
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_restaurants);
        } else if (position == 1) {
            return mContext.getString(R.string.category_bars);
        } else if (position == 2) {
            return mContext.getString(R.string.category_shops);
        } else {
            return mContext.getString(R.string.category_hotels);
        }
    }
}
