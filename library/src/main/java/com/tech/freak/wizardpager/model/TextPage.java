package com.tech.freak.wizardpager.model;

import java.util.ArrayList;

import android.app.Fragment;
import android.text.TextUtils;
import com.tech.freak.wizardpager.ui.TextFragment;

public class TextPage extends Page
{
	public TextPage(ModelCallbacks callbacks, String name, String title) {
		super(callbacks, name, title);
	}

	@Override
	public Fragment createFragment() {
		return TextFragment.create(getKey());
	}

	@Override
	public void getReviewItems(ArrayList<ReviewItem> dest) {
		dest.add(new ReviewItem(getTitle(), _data.getString(DK_STRING),	getKey()));
	}

	@Override
	public boolean isCompleted() {
		return !TextUtils.isEmpty(_data.getString(DK_STRING));
	}

	public TextPage setValue(String value) {
		_data.putString(DK_STRING, value);
		return this;
	}

	public TextPage setHint(String value) {
		_data.putString(DK_HINT, value);
		return this;
	}

	public TextPage setMaxLength(int value) {
		_data.putInt(DK_MAX_LENGTH, value);
		return this;
	}
}
