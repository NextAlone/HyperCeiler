package com.sevtinge.hyperceiler.module.hook.screenrecorder;

import com.sevtinge.hyperceiler.module.base.BaseHook;

import de.robv.android.xposed.XposedHelpers;

public class UnlockMoreVolumeFrom extends BaseHook {
    @Override
    public void init() {
        Class<?> mVolumeFrom = findClassIfExists("w0.a");
        findAndHookConstructor("w0.a", new MethodHook() {
            @Override
            protected void after(MethodHookParam param) throws Throwable {
                XposedHelpers.setStaticBooleanField(mVolumeFrom, "h", true);
            }
        });
    }
}
