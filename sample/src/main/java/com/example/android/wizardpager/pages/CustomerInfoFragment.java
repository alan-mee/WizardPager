package com.example.android.wizardpager.pages;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.example.android.wizardpager.R;
import com.tech.freak.wizardpager.ui.PageFragmentCallbacks;

/**
 * Created by TechFreak on 04/09/2014.
 */
public class CustomerInfoFragment extends Fragment
{
	private static final String ARG_KEY = "key";

	private PageFragmentCallbacks _callbacks;
	private String _key;
	private CustomerInfoPage _page;
	private TextView _nameView;
	private TextView _emailView;

	public static CustomerInfoFragment create(String key)
	{
		Bundle args = new Bundle();
		args.putString(ARG_KEY, key);

		CustomerInfoFragment fragment = new CustomerInfoFragment();
		fragment.setArguments(args);
		return fragment;
	}

	public CustomerInfoFragment()
	{
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		Bundle args = getArguments();
		_key = args.getString(ARG_KEY);
		_page = (CustomerInfoPage) _callbacks.onGetPage(_key);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
													 Bundle savedInstanceState)
	{
		View rootView = inflater.inflate(R.layout.fragment_page_customer_info, container, false);
		((TextView) rootView.findViewById(android.R.id.title)).setText(_page.getTitle());

		_nameView = ((TextView) rootView.findViewById(R.id.your_name));
		_nameView.setText(_page.getData().getString(CustomerInfoPage.NAME_DATA_KEY));

		_emailView = ((TextView) rootView.findViewById(R.id.your_email));
		_emailView.setText(_page.getData().getString(CustomerInfoPage.EMAIL_DATA_KEY));

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

		_nameView.addTextChangedListener(new TextWatcher()
		{
			@Override
			public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)
			{
			}

			@Override
			public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
			{
			}

			@Override
			public void afterTextChanged(Editable editable)
			{
				_page.getData().putString(CustomerInfoPage.NAME_DATA_KEY,
					(editable != null) ? editable.toString() : null);
				_page.notifyDataChanged();
			}
		});

		_emailView.addTextChangedListener(new TextWatcher()
		{
			@Override
			public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)
			{
			}

			@Override
			public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
			{
			}

			@Override
			public void afterTextChanged(Editable editable)
			{
				_page.getData().putString(CustomerInfoPage.EMAIL_DATA_KEY,
					(editable != null) ? editable.toString() : null);
				_page.notifyDataChanged();
			}
		});
	}

	@Override
	public void setMenuVisibility(boolean menuVisible)
	{
		super.setMenuVisibility(menuVisible);

		// In a future update to the support library, this should override setUserVisibleHint
		// instead of setMenuVisibility.
		if (_nameView != null) {
			InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(
				Context.INPUT_METHOD_SERVICE);
			if (!menuVisible) {
				imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
			}
		}
	}
}
