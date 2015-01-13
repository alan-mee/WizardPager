package com.tech.freak.wizardpager.model;

import java.util.ArrayList;

import android.app.Fragment;
import android.text.TextUtils;
import com.tech.freak.wizardpager.ui.TextFragment;

public class TextPage extends Page {

	public TextPage(ModelCallbacks callbacks, String title) {
		super(callbacks, title);
	}

	@Override
	public Fragment createFragment() {
		return TextFragment.create(getKey());
	}

	@Override
	public void getReviewItems(ArrayList<ReviewItem> dest) {
		dest.add(new ReviewItem(getTitle(), _data.getString(SIMPLE_DATA_KEY),	getKey()));
	}

	@Override
	public boolean isCompleted() {
		return !TextUtils.isEmpty(_data.getString(SIMPLE_DATA_KEY));
	}

	public TextPage setValue(String value) {
		_data.putString(SIMPLE_DATA_KEY, value);
		return this;
	}
}
