package com.tech.freak.wizardpager.model;

import android.app.Fragment;

import com.tech.freak.wizardpager.ui.GeoFragment;

public class GeoPage extends TextPage
{
	public GeoPage(ModelCallbacks callbacks, String name, String title)
	{
		super(callbacks, name, title);
	}

	@Override
	public Fragment createFragment()
	{
		return GeoFragment.create(getKey());
	}

	public GeoPage setValue(String value)
	{
		_data.putString(DK_STRING, value);
		return this;
	}
}
