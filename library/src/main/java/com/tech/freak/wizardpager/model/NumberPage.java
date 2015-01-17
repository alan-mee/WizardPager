package com.tech.freak.wizardpager.model;

import android.app.Fragment;

import com.tech.freak.wizardpager.ui.NumberFragment;

public class NumberPage extends TextPage
{
	public NumberPage(ModelCallbacks callbacks, String name, String title)
	{
		super(callbacks, name, title);
	}

	@Override
	public Fragment createFragment()
	{
		return NumberFragment.create(getKey());
	}
}
