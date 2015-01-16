package com.example.android.wizardpager.pages;

import android.app.Fragment;
import android.text.TextUtils;

import com.tech.freak.wizardpager.model.ModelCallbacks;
import com.tech.freak.wizardpager.model.Page;
import com.tech.freak.wizardpager.model.ReviewItem;

import java.util.ArrayList;

/**
 * A page asking for a name and an email.
 */
public class CustomerInfoPage extends Page
{
	public static final String NAME_DATA_KEY = "name";
	public static final String EMAIL_DATA_KEY = "email";

	public CustomerInfoPage(ModelCallbacks callbacks, String title)
	{
		super(callbacks, title);
	}

	@Override
	public Fragment createFragment()
	{
		return CustomerInfoFragment.create(getKey());
	}

	@Override
	public void getReviewItems(ArrayList<ReviewItem> dest)
	{
		dest.add(new ReviewItem("Your name", _data.getString(NAME_DATA_KEY), getKey(), -1));
		dest.add(new ReviewItem("Your email", _data.getString(EMAIL_DATA_KEY), getKey(), -1));
	}

	@Override
	public boolean isCompleted()
	{
		return !TextUtils.isEmpty(_data.getString(NAME_DATA_KEY));
	}
}
