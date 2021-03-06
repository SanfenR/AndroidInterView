package co.sanfen.android.androidinterview.activity.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import co.sanfen.android.androidinterview.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends Fragment {
    private String TAG;
    TextView mTvName;

    private boolean mIsPrepared, mIsInited;
    public static final String NAME= "name";
    public OneFragment() {
        // Required empty public constructor
    }
    public static OneFragment newInstance(String name) {
        Bundle args = new Bundle();
        OneFragment fragment = new OneFragment();
        args.putString(NAME, name);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e(TAG, "onAttach");
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = getArguments().getString(NAME);
        Log.e(TAG, "onCreate");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e(TAG, "onCreateView");
        View inflate = inflater.inflate(R.layout.fragment_one, container, false);
        mTvName = inflate.findViewById(R.id.tv_name);
        mTvName.setText(TAG);
        mIsPrepared = true;
        lazyLoad();
        return inflate;
    }

    public void lazyLoad() {
        if (getUserVisibleHint() && mIsPrepared && !mIsInited) {
            //异步初始化，在初始化后显示正常UI
            loadData();
        }
    }

    private void loadData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                mIsInited = true;
            }
        }).start();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(TAG, "onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(TAG, "onStart");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG, "onPause");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");
    }


    @Override
    public void onStop() {
        super.onStop();
        Log.e(TAG, "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mIsPrepared = false;
        Log.e(TAG, "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e(TAG, "onDetach");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e(TAG, "onSaveInstanceState");
    }

}
