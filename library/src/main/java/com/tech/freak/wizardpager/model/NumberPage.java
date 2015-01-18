package com.tech.freak.wizardpager.model;

import android.app.Fragment;
import android.content.res.Resources;

import com.tech.freak.wizardpager.ui.NumberFragment;

public class NumberPage extends TextPage
{
	public NumberPage(ModelCallbacks callbacks, Resources resources, String name, String title)
	{
		super(callbacks, resources, name, title);
	}

	@Override
	public Fragment createFragment()
	{
		return NumberFragment.create(getKey());
	}
}
