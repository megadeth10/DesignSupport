package com.dondeath.designsupport.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dondeath.designsupport.R;

/**
 * Created by PLUUSYSTEM-NEW on 2015-05-31.
 */
public class TabsFragment extends Fragment {
	TabLayout tabLayout;
	ViewPager viewPager;

	private final int TAB_COUNT = 10;

	public static TabsFragment newInstance() {
		TabsFragment fragment = new TabsFragment();
		return fragment;
	}

	public TabsFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_tabs, container, false);
		tabLayout = (TabLayout)rootView.findViewById(R.id.tabLayout);
		viewPager = (ViewPager)rootView.findViewById(R.id.viewPager);
		return rootView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

//		for (int i = 0; i < TAB_COUNT; i++) {
//			tabLayout.addTab(tabLayout.newTab().setText("TAB " + i));
//		}

		TabPagerAdapter adapter = new TabPagerAdapter(getFragmentManager());
		viewPager.setAdapter(adapter);
		tabLayout.setupWithViewPager(viewPager);
		tabLayout.setTabsFromPagerAdapter(adapter);
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		tabLayout = null;
		viewPager = null;

	}

	private class TabPagerAdapter extends FragmentPagerAdapter {

		public TabPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			return CurrentFragment.CurrentFragment(position);
		}

		@Override
		public int getCount() {
			return TAB_COUNT;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return "TAB " + position;
		}
	}

	public static class CurrentFragment extends Fragment {
		TextView textView;

		private static final String ARGS_KEY = "idx";

		public static CurrentFragment CurrentFragment(int position) {
			CurrentFragment fragment = new CurrentFragment();
			Bundle bundle = new Bundle();
			bundle.putInt(ARGS_KEY, position);
			fragment.setArguments(bundle);
			return fragment;
		}

		public CurrentFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
								 Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_tab_fragment, container, false);
			textView = (TextView)rootView.findViewById(R.id.textView);
			return rootView;
		}

		@Override
		public void onActivityCreated(Bundle savedInstanceState) {
			super.onActivityCreated(savedInstanceState);
			int idx = getArguments().getInt(ARGS_KEY, -1);
			textView.setText("Page Position=" + idx);
		}

		@Override
		public void onDestroyView() {
			super.onDestroyView();
			textView = null;
		}
	}
}
