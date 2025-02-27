package com.sevtinge.hyperceiler.module.hook.home.title;

import static de.robv.android.xposed.XposedHelpers.callMethod;

import com.github.kyuubiran.ezxhelper.ClassUtils;
import com.sevtinge.hyperceiler.module.base.BaseHook;

import de.robv.android.xposed.XC_MethodHook;

public class AnimParamCustom extends BaseHook {
    @Override
    public void init() {
        hookAllMethods("com.miui.home.recents.util.RectFSpringAnim", "setAnimParamByType", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws NoSuchFieldException, ClassNotFoundException {
                Class<?> clazzRectFSpringAnim = ClassUtils.loadClass("com.miui.home.recents.util.RectFSpringAnim", null);
                Object RECT_CENTERX = ClassUtils.getStaticObjectOrNull(clazzRectFSpringAnim, "RECT_CENTERX");
                Object RECT_CENTERY = ClassUtils.getStaticObjectOrNull(clazzRectFSpringAnim, "RECT_CENTERY");
                Object RECT_WIDTH = ClassUtils.getStaticObjectOrNull(clazzRectFSpringAnim, "RECT_WIDTH");
                Object RECT_RATIO = ClassUtils.getStaticObjectOrNull(clazzRectFSpringAnim, "RECT_RATIO");
                Object RADIUS = ClassUtils.getStaticObjectOrNull(clazzRectFSpringAnim, "RADIUS");
                Object ALPHA = ClassUtils.getStaticObjectOrNull(clazzRectFSpringAnim, "ALPHA");
                Enum animType = (Enum) param.args[0];
                switch (animType.name()) {
                    case "BREAK_OPEN" -> {// 1
                        callMethod(param.thisObject, "setAnimParam", RECT_CENTERX, ((float) mPrefsMap.getInt("home_title_custom_anim_param_damping_RECT_CENTERX_1", 990) / 1000), ((float) mPrefsMap.getInt("home_title_custom_anim_param_stiffness_RECT_CENTERX_1", 135) / 1000));// 0.99 0.135
                        callMethod(param.thisObject, "setAnimParam", RECT_CENTERY, ((float) mPrefsMap.getInt("home_title_custom_anim_param_damping_RECT_CENTERY_1", 990) / 1000), ((float) mPrefsMap.getInt("home_title_custom_anim_param_stiffness_RECT_CENTERY_1", 135) / 1000));// 0.99 0.135
                        callMethod(param.thisObject, "setAnimParam", RECT_WIDTH, ((float) mPrefsMap.getInt("home_title_custom_anim_param_damping_RECT_WIDTH_1", 990) / 1000), ((float) mPrefsMap.getInt("home_title_custom_anim_param_stiffness_RECT_WIDTH_1", 135) / 1000));// 0.99 0.135
                        callMethod(param.thisObject, "setAnimParam", RECT_RATIO, ((float) mPrefsMap.getInt("home_title_custom_anim_param_damping_RECT_RATIO_1", 990) / 1000), ((float) mPrefsMap.getInt("home_title_custom_anim_param_stiffness_RECT_RATIO_1", 135) / 1000));// 0.99 0.135
                        callMethod(param.thisObject, "setAnimParam", RADIUS, ((float) mPrefsMap.getInt("home_title_custom_anim_param_damping_RADIUS_1", 990) / 1000), ((float) mPrefsMap.getInt("home_title_custom_anim_param_stiffness_RADIUS_1", 135) / 1000));// 0.99 0.135
                        callMethod(param.thisObject, "setAnimParam", ALPHA, ((float) mPrefsMap.getInt("home_title_custom_anim_param_damping_ALPHA_1", 990) / 1000), ((float) mPrefsMap.getInt("home_title_custom_anim_param_stiffness_ALPHA_1", 135) / 1000));// 0.99 0.135
                    }
                    case "OPEN_FROM_HOME" -> {// 2
                        callMethod(param.thisObject, "setAnimParam", RECT_CENTERX, ((float) mPrefsMap.getInt("home_title_custom_anim_param_damping_RECT_CENTERX_2", 960) / 1000), ((float) mPrefsMap.getInt("home_title_custom_anim_param_stiffness_RECT_CENTERX_2", 300) / 1000));
                        callMethod(param.thisObject, "setAnimParam", RECT_CENTERY, ((float) mPrefsMap.getInt("home_title_custom_anim_param_damping_RECT_CENTERY_2", 960) / 1000), ((float) mPrefsMap.getInt("home_title_custom_anim_param_stiffness_RECT_CENTERY_2", 300) / 1000));
                        callMethod(param.thisObject, "setAnimParam", RECT_WIDTH, ((float) mPrefsMap.getInt("home_title_custom_anim_param_damping_RECT_WIDTH_2", 960) / 1000), ((float) mPrefsMap.getInt("home_title_custom_anim_param_stiffness_RECT_WIDTH_2", 410) / 1000));
                        callMethod(param.thisObject, "setAnimParam", RECT_RATIO, ((float) mPrefsMap.getInt("home_title_custom_anim_param_damping_RECT_RATIO_2", 960) / 1000), ((float) mPrefsMap.getInt("home_title_custom_anim_param_stiffness_RECT_RATIO_2", 340) / 1000));
                        callMethod(param.thisObject, "setAnimParam", RADIUS, ((float) mPrefsMap.getInt("home_title_custom_anim_param_damping_RADIUS_2", 990) / 1000), ((float) mPrefsMap.getInt("home_title_custom_anim_param_stiffness_RADIUS_2", 225) / 1000));
                        callMethod(param.thisObject, "setAnimParam", ALPHA, ((float) mPrefsMap.getInt("home_title_custom_anim_param_damping_ALPHA_2", 990) / 1000), ((float) mPrefsMap.getInt("home_title_custom_anim_param_stiffness_ALPHA_2", 135) / 1000));
                    }
                    case "OPEN_FROM_RECENTS" -> {// 3
                        callMethod(param.thisObject, "setAnimParam", RECT_CENTERX, ((float) mPrefsMap.getInt("home_title_custom_anim_param_damping_RECT_CENTERX_3", 900) / 1000), ((float) mPrefsMap.getInt("home_title_custom_anim_param_stiffness_RECT_CENTERX_3", 270) / 1000));
                        callMethod(param.thisObject, "setAnimParam", RECT_CENTERY, ((float) mPrefsMap.getInt("home_title_custom_anim_param_damping_RECT_CENTERY_3", 900) / 1000), ((float) mPrefsMap.getInt("home_title_custom_anim_param_stiffness_RECT_CENTERY_3", 270) / 1000));
                        callMethod(param.thisObject, "setAnimParam", RECT_WIDTH, ((float) mPrefsMap.getInt("home_title_custom_anim_param_damping_RECT_WIDTH_3", 990) / 1000), ((float) mPrefsMap.getInt("home_title_custom_anim_param_stiffness_RECT_WIDTH_3", 360) / 1000));
                        callMethod(param.thisObject, "setAnimParam", RECT_RATIO, ((float) mPrefsMap.getInt("home_title_custom_anim_param_damping_RECT_RATIO_3", 990) / 1000), ((float) mPrefsMap.getInt("home_title_custom_anim_param_stiffness_RECT_RATIO_3", 360) / 1000));
                    }
                    case "CLOSE_TO_RECENTS" -> {// 4
                        callMethod(param.thisObject, "setAnimParam", RECT_CENTERX, ((float) mPrefsMap.getInt("home_title_custom_anim_param_damping_RECT_CENTERX_4", 950) / 1000), ((float) mPrefsMap.getInt("home_title_custom_anim_param_stiffness_RECT_CENTERX_4", 315) / 1000));
                        callMethod(param.thisObject, "setAnimParam", RECT_CENTERY, ((float) mPrefsMap.getInt("home_title_custom_anim_param_damping_RECT_CENTERY_4", 950) / 1000), ((float) mPrefsMap.getInt("home_title_custom_anim_param_stiffness_RECT_CENTERY_4", 315) / 1000));
                        callMethod(param.thisObject, "setAnimParam", RECT_WIDTH, ((float) mPrefsMap.getInt("home_title_custom_anim_param_damping_RECT_WIDTH_4", 950) / 1000), ((float) mPrefsMap.getInt("home_title_custom_anim_param_stiffness_RECT_WIDTH_4", 315) / 1000));
                        callMethod(param.thisObject, "setAnimParam", RECT_RATIO, ((float) mPrefsMap.getInt("home_title_custom_anim_param_damping_RECT_RATIO_4", 950) / 1000), ((float) mPrefsMap.getInt("home_title_custom_anim_param_stiffness_RECT_RATIO_4", 270) / 1000));
                        callMethod(param.thisObject, "setAnimParam", RADIUS, ((float) mPrefsMap.getInt("home_title_custom_anim_param_damping_RADIUS_4", 990) / 1000), ((float) mPrefsMap.getInt("home_title_custom_anim_param_stiffness_RADIUS_4", 270) / 1000));
                        callMethod(param.thisObject, "setAnimParam", ALPHA, ((float) mPrefsMap.getInt("home_title_custom_anim_param_damping_ALPHA_4", 990) / 1000), ((float) mPrefsMap.getInt("home_title_custom_anim_param_stiffness_ALPHA_4", 270) / 1000));
                    }
                    case "CLOSE_TO_HOME" -> {// 5
                        callMethod(param.thisObject, "setAnimParam", RECT_CENTERX, ((float) mPrefsMap.getInt("home_title_custom_anim_param_damping_RECT_CENTERX_5", 990) / 1000), ((float) mPrefsMap.getInt("home_title_custom_anim_param_stiffness_RECT_CENTERX_5", 450) / 1000));
                        callMethod(param.thisObject, "setAnimParam", RECT_CENTERY, ((float) mPrefsMap.getInt("home_title_custom_anim_param_damping_RECT_CENTERY_5", 990) / 1000), ((float) mPrefsMap.getInt("home_title_custom_anim_param_stiffness_RECT_CENTERY_5", 450) / 1000));
                        callMethod(param.thisObject, "setAnimParam", RECT_WIDTH, ((float) mPrefsMap.getInt("home_title_custom_anim_param_damping_RECT_WIDTH_5", 900) / 1000), ((float) mPrefsMap.getInt("home_title_custom_anim_param_stiffness_RECT_WIDTH_5", 450) / 1000));
                        callMethod(param.thisObject, "setAnimParam", RECT_RATIO, ((float) mPrefsMap.getInt("home_title_custom_anim_param_damping_RECT_RATIO_5", 990) / 1000), ((float) mPrefsMap.getInt("home_title_custom_anim_param_stiffness_RECT_RATIO_5", 370) / 1000));
                        callMethod(param.thisObject, "setAnimParam", RADIUS, ((float) mPrefsMap.getInt("home_title_custom_anim_param_damping_RADIUS_5", 990) / 1000), ((float) mPrefsMap.getInt("home_title_custom_anim_param_stiffness_RADIUS_5", 150) / 1000));
                        callMethod(param.thisObject, "setAnimParam", ALPHA, ((float) mPrefsMap.getInt("home_title_custom_anim_param_damping_ALPHA_5", 990) / 1000), ((float) mPrefsMap.getInt("home_title_custom_anim_param_stiffness_ALPHA_5", 420) / 1000));
                    }
                    case "CLOSE_FROM_FEED" -> {// 6
                        callMethod(param.thisObject, "setAnimParam", RECT_CENTERX, ((float) mPrefsMap.getInt("home_title_custom_anim_param_damping_RECT_CENTERX_6", 950) / 1000), ((float) mPrefsMap.getInt("home_title_custom_anim_param_stiffness_RECT_CENTERX_6", 378) / 1000));
                        callMethod(param.thisObject, "setAnimParam", RECT_CENTERY, ((float) mPrefsMap.getInt("home_title_custom_anim_param_damping_RECT_CENTERY_6", 950) / 1000), ((float) mPrefsMap.getInt("home_title_custom_anim_param_stiffness_RECT_CENTERY_6", 378) / 1000));
                        callMethod(param.thisObject, "setAnimParam", RECT_WIDTH, ((float) mPrefsMap.getInt("home_title_custom_anim_param_damping_RECT_WIDTH_6", 900) / 1000), ((float) mPrefsMap.getInt("home_title_custom_anim_param_stiffness_RECT_WIDTH_6", 405) / 1000));
                        callMethod(param.thisObject, "setAnimParam", RECT_RATIO, ((float) mPrefsMap.getInt("home_title_custom_anim_param_damping_RECT_RATIO_6", 950) / 1000), ((float) mPrefsMap.getInt("home_title_custom_anim_param_stiffness_RECT_RATIO_6", 333) / 1000));
                        callMethod(param.thisObject, "setAnimParam", RADIUS, ((float) mPrefsMap.getInt("home_title_custom_anim_param_damping_RADIUS_6", 990) / 1000), ((float) mPrefsMap.getInt("home_title_custom_anim_param_stiffness_RADIUS_6", 180) / 1000));
                        callMethod(param.thisObject, "setAnimParam", ALPHA, ((float) mPrefsMap.getInt("home_title_custom_anim_param_damping_ALPHA_6", 990) / 1000), ((float) mPrefsMap.getInt("home_title_custom_anim_param_stiffness_ALPHA_6", 378) / 1000));
                    }
                    case "APP_TO_APP" -> {// 7
                        callMethod(param.thisObject, "setAnimParam", RECT_CENTERX, ((float) mPrefsMap.getInt("home_title_custom_anim_param_damping_RECT_CENTERX_7", 900) / 1000), ((float) mPrefsMap.getInt("home_title_custom_anim_param_stiffness_RECT_CENTERX_7", 315) / 1000));
                        callMethod(param.thisObject, "setAnimParam", RECT_CENTERY, ((float) mPrefsMap.getInt("home_title_custom_anim_param_damping_RECT_CENTERY_7", 900) / 1000), ((float) mPrefsMap.getInt("home_title_custom_anim_param_stiffness_RECT_CENTERY_7", 315) / 1000));
                        callMethod(param.thisObject, "setAnimParam", RECT_WIDTH, ((float) mPrefsMap.getInt("home_title_custom_anim_param_damping_RECT_WIDTH_7", 990) / 1000), ((float) mPrefsMap.getInt("home_title_custom_anim_param_stiffness_RECT_WIDTH_7", 315) / 1000));
                        callMethod(param.thisObject, "setAnimParam", RECT_RATIO, ((float) mPrefsMap.getInt("home_title_custom_anim_param_damping_RECT_RATIO_7", 990) / 1000), ((float) mPrefsMap.getInt("home_title_custom_anim_param_stiffness_RECT_RATIO_7", 315) / 1000));
                    }
                    case "START_FIRST_TASK" -> {// 8
                        callMethod(param.thisObject, "setAnimParam", RECT_CENTERX, ((float) mPrefsMap.getInt("home_title_custom_anim_param_damping_RECT_CENTERX_8", 900) / 1000), ((float) mPrefsMap.getInt("home_title_custom_anim_param_stiffness_RECT_CENTERX_8", 180) / 1000));
                        callMethod(param.thisObject, "setAnimParam", RECT_CENTERY, ((float) mPrefsMap.getInt("home_title_custom_anim_param_damping_RECT_CENTERY_8", 900) / 1000), ((float) mPrefsMap.getInt("home_title_custom_anim_param_stiffness_RECT_CENTERY_8", 180) / 1000));
                        callMethod(param.thisObject, "setAnimParam", RECT_WIDTH, ((float) mPrefsMap.getInt("home_title_custom_anim_param_damping_RECT_WIDTH_8", 990) / 1000), ((float) mPrefsMap.getInt("home_title_custom_anim_param_stiffness_RECT_WIDTH_8", 180) / 1000));
                        callMethod(param.thisObject, "setAnimParam", RECT_RATIO, ((float) mPrefsMap.getInt("home_title_custom_anim_param_damping_RECT_RATIO_8", 990) / 1000), ((float) mPrefsMap.getInt("home_title_custom_anim_param_stiffness_RECT_RATIO_8", 180) / 1000));
                    }
                    default -> {
                    }
                }
                param.setResult(null);
            }
        });
    }
}
