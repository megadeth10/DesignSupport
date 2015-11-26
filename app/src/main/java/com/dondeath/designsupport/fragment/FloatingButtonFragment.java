package com.dondeath.designsupport.fragment;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dondeath.designsupport.R;

/**
 * Created by PLUUSYSTEM-NEW on 2015-05-31.
 */
public class FloatingButtonFragment extends Fragment
	implements View.OnClickListener {

	CoordinatorLayout coordinatorLayout;

	public static FloatingButtonFragment newInstance() {
		FloatingButtonFragment fragment = new FloatingButtonFragment();
		return fragment;
	}

	public FloatingButtonFragment() { }

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_floating_button, container, false);
		coordinatorLayout = (CoordinatorLayout)rootView.findViewById(R.id.coordinatorLayout);
		return rootView;
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		coordinatorLayout = null;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.actionButton:
				Snackbar
						.make(coordinatorLayout, R.string.snackbar_text, Snackbar.LENGTH_LONG)
						.setAction(R.string.snackbar_action, this)
						.setActionTextColor(getResources().getColor(R.color.color_snackbar_action))
						.show();
				break;
		}
	}
}
