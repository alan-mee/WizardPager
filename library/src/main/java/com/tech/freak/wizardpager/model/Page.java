/*
 * Copyright 2012 Roman Nurik
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tech.freak.wizardpager.model;

import android.app.Fragment;
import android.os.Bundle;

import java.util.ArrayList;

/**
 * Represents a single page in the wizard.
 */
public abstract class Page implements PageTreeNode
{
	/**
	 * The key into {@link #getData()} used for wizards with simple (single) values.
	 */
	public static final String SIMPLE_DATA_KEY = "_";

	protected ModelCallbacks _callbacks;

	/**
	 * Current wizard values/selections.
	 */
	protected Bundle _data = new Bundle();
	protected String _title;
	protected boolean _required = false;
	protected String _parentKey;

	protected Page(ModelCallbacks callbacks, String title)
	{
		_callbacks = callbacks;
		_title = title;
	}

	public Bundle getData()
	{
		return _data;
	}

	public String getTitle()
	{
		return _title;
	}

	public boolean isRequired()
	{
		return _required;
	}

	void setParentKey(String parentKey)
	{
		_parentKey = parentKey;
	}

	@Override
	public Page findByKey(String key)
	{
		return getKey().equals(key) ? this : null;
	}

	@Override
	public void flattenCurrentPageSequence(ArrayList<Page> dest)
	{
		dest.add(this);
	}

	public abstract Fragment createFragment();

	public String getKey()
	{
		return (_parentKey != null) ? _parentKey + ":" + _title : _title;
	}

	public abstract void getReviewItems(ArrayList<ReviewItem> dest);

	public boolean isCompleted()
	{
		return true;
	}

	public void resetData(Bundle data)
	{
		_data = data;
		notifyDataChanged();
	}

	public void notifyDataChanged()
	{
		_callbacks.onPageDataChanged(this);
	}

	public Page setRequired(boolean required)
	{
		_required = required;
		return this;
	}
}
