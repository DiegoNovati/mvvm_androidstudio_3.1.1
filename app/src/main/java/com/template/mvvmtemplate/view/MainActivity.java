package com.template.mvvmtemplate.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.template.mvvmtemplate.R;
import com.template.mvvmtemplate.databinding.ActivityMainBinding;
import com.template.mvvmtemplate.viewmodel.MainViewModel;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);

            ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
            activityMainBinding.setMainViewModel(new MainViewModel(this));
        } catch (Exception ex) {
            logError(ex);
        }
    }
}
