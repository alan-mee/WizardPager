package com.tech.freak.wizardpager.model;

import android.app.Fragment;

import com.tech.freak.wizardpager.ui.ImageFragment;

public class ImagePage extends TextPage
{
	public ImagePage(ModelCallbacks callbacks, String name, String title)
	{
		super(callbacks, name, title);
	}

	@Override
	public Fragment createFragment()
	{
		return ImageFragment.create(getKey());
	}

	public ImagePage setValue(String value)
	{
		_data.putString(DK_STRING, value);
		return this;
	}
}
