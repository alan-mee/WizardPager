package com.tech.freak.wizardpager.ui;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.tech.freak.wizardpager.R;
import com.tech.freak.wizardpager.model.Page;

public class TextFragment extends Fragment
{
	protected static final String ARG_KEY = "key";

	private PageFragmentCallbacks _callbacks;
	private String _key;
	private Page _page;

	protected EditText _editTextInput;

	public static TextFragment create(String key)
	{
		Bundle args = new Bundle();
		args.putString(ARG_KEY, key);

		TextFragment f = new TextFragment();
		f.setArguments(args);
		return f;
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		Bundle args = getArguments();
		_key = args.getString(ARG_KEY);
		_page = _callbacks.onGetPage(_key);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View rootView = inflater.inflate(R.layout.fragment_page_text, container, false);
		((TextView) rootView.findViewById(android.R.id.title)).setText(_page.getTitle());

		_editTextInput = (EditText) rootView.findViewById(R.id.editTextInput);
		_editTextInput.setText(_page.getData().getString(Page.DK_STRING));
		_editTextInput.setHint(_page.getData().getString(Page.DK_HINT));
		int maxLength = _page.getData().getInt(Page.DK_MAX_LENGTH);
		if (maxLength > 0)
			_editTextInput.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength)});
		return rootView;
	}

	@Override
	public void onAttach(Activity activity)
	{
		super.onAttach(activity);

		if (!(activity instanceof PageFragmentCallbacks)) {
			throw new ClassCastException("Activity must implement PageFragmentCallbacks");
		}

		_callbacks = (PageFragmentCallbacks) activity;
	}

	@Override
	public void onDetach()
	{
		super.onDetach();
		_callbacks = null;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState)
	{
		super.onViewCreated(view, savedInstanceState);
		setInputType();
		_editTextInput.addTextChangedListener(new TextWatcher()
		{
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after)
			{
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count)
			{
			}

			@Override
			public void afterTextChanged(Editable editable)
			{
				_page.getData().putString(Page.DK_STRING, (editable != null) ? editable.toString() : null);
				_page.notifyDataChanged();
			}
		});
	}

	protected void setInputType()
	{
		_editTextInput.setInputType(InputType.TYPE_CLASS_TEXT);
	}

	@Override
	public void setMenuVisibility(boolean menuVisible)
	{
		super.setMenuVisibility(menuVisible);

		// In a future update to the support library, this should override setUserVisibleHint
		// instead of setMenuVisibility.
		if (_editTextInput != null) {
			InputMethodManager imm = (InputMethodManager) getActivity()
				.getSystemService(Context.INPUT_METHOD_SERVICE);
			if (!menuVisible) {
				imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
			}
		}
	}
}
