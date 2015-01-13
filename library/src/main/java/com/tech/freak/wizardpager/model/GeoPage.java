package com.tech.freak.wizardpager.model;

import android.app.Fragment;

import com.tech.freak.wizardpager.ui.GeoFragment;

public class GeoPage extends TextPage {

	public GeoPage(ModelCallbacks callbacks, String title) {
		super(callbacks, title);
	}

	@Override
	public Fragment createFragment() {
		return GeoFragment.create(getKey());
	}

	public GeoPage setValue(String value) {
		_data.putString(SIMPLE_DATA_KEY, value);
		return this;
	}
}
