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

/**
 * Represents a single line item on the final review page.
 * <p>
 * see com.example.android.wizardpager.wizard.ui.ReviewFragment
 */
public class ReviewItem
{
	public static final int DEFAULT_WEIGHT = 0;

	private int _weight;
	private String _title;
	private String _displayValue;
	private String _pageKey;

	public ReviewItem(String title, String displayValue, String pageKey)
	{
		this(title, displayValue, pageKey, DEFAULT_WEIGHT);
	}

	public ReviewItem(String title, String displayValue, String pageKey, int weight)
	{
		_title = title;
		_displayValue = displayValue;
		_pageKey = pageKey;
		_weight = weight;
	}

	public String getDisplayValue()
	{
		return _displayValue;
	}

	public void setDisplayValue(String displayValue)
	{
		_displayValue = displayValue;
	}

	public String getPageKey()
	{
		return _pageKey;
	}

	public void setPageKey(String pageKey)
	{
		_pageKey = pageKey;
	}

	public String getTitle()
	{
		return _title;
	}

	public void setTitle(String title)
	{
		_title = title;
	}

	public int getWeight()
	{
		return _weight;
	}

	public void setWeight(int weight)
	{
		_weight = weight;
	}
}
