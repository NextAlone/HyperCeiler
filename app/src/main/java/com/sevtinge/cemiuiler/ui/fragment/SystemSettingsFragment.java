package com.sevtinge.cemiuiler.ui.fragment;

import android.view.View;

import com.sevtinge.cemiuiler.R;
import com.sevtinge.cemiuiler.ui.base.BaseSettingsActivity;
import com.sevtinge.cemiuiler.ui.fragment.base.SettingsPreferenceFragment;
import com.sevtinge.cemiuiler.utils.devicesdk.SdkHelper;

import moralnorm.preference.PreferenceCategory;
import moralnorm.preference.SwitchPreference;

public class SystemSettingsFragment extends SettingsPreferenceFragment {
    PreferenceCategory mHighMode; // 极致模式
    SwitchPreference mAreaScreenshot; // 区域截屏
    SwitchPreference mKnuckleFunction; // 指关节相关

    @Override
    public int getContentResId() {
        return R.xml.system_settings;
    }

    @Override
    public View.OnClickListener addRestartListener() {
        return view -> ((BaseSettingsActivity)getActivity()).showRestartDialog(
            getResources().getString(R.string.system_settings),
            "com.android.settings"
        );
    }

    @Override
    public void initPrefs() {
        mHighMode = findPreference("prefs_key_system_settings_develop_speed");
        mAreaScreenshot = findPreference("prefs_key_system_settings_area_screenshot");
        mKnuckleFunction = findPreference("prefs_key_system_settings_knuckle_function");
        mHighMode.setVisible(!SdkHelper.isAndroidR());
        mAreaScreenshot.setVisible(SdkHelper.isAndroidR());
        mKnuckleFunction.setVisible(SdkHelper.PROP_MIUI_VERSION_CODE >= 13);
    }
}
