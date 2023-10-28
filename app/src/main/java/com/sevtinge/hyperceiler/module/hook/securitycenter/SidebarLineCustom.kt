package com.sevtinge.hyperceiler.module.hook.securitycenter

import com.sevtinge.hyperceiler.module.base.BaseHook

import de.robv.android.xposed.callbacks.XC_InitPackageResources

object SidebarLineCustom : BaseHook() {

    override fun init() {}

    fun initResource(resParam: XC_InitPackageResources.InitPackageResourcesParam) {
        val mSidebarLineColorDefault =
            mPrefsMap.getInt("security_center_sidebar_line_color_default", -1294740525)
        val mSidebarLineColorDark =
            mPrefsMap.getInt("security_center_sidebar_line_color_dark", -6842473)
        val mSidebarLineColorLight =
            mPrefsMap.getInt("security_center_sidebar_line_color_light", -872415232)
        logI(
            TAG,
            "com.miui.securitycenter",
            "mSidebarLineColorDefault is $mSidebarLineColorDefault"
        )
        logI(TAG, "com.miui.securitycenter", "mSidebarLineColorDark is $mSidebarLineColorDark")
        logI(TAG, "com.miui.securitycenter", "mSidebarLineColorLight is $mSidebarLineColorLight")
        resParam.res.setReplacement(
            "com.miui.securitycenter",
            "color",
            "sidebar_line_color",
            mSidebarLineColorDefault
        )
        resParam.res.setReplacement(
            "com.miui.securitycenter",
            "color",
            "sidebar_line_color_dark",
            mSidebarLineColorLight
        )
        resParam.res.setReplacement(
            "com.miui.securitycenter",
            "color",
            "sidebar_line_color_light",
            mSidebarLineColorDark
        )
    }


}
