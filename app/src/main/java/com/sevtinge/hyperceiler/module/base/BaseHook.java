package com.sevtinge.hyperceiler.module.base;

import com.sevtinge.hyperceiler.XposedInit;
import com.sevtinge.hyperceiler.utils.ResourcesHook;
import com.sevtinge.hyperceiler.utils.log.XposedLogUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public abstract class BaseHook extends XposedLogUtils {
    public String TAG = getClass().getSimpleName();

    public LoadPackageParam lpparam;
    public static final ResourcesHook mResHook = XposedInit.mResHook;

    public static final String ACTION_PREFIX = "com.sevtinge.hyperceiler.module.action.";

    public abstract void init();

    public void onCreate(LoadPackageParam lpparam) {
        try {
            setLoadPackageParam(lpparam);
            init();
            if (detailLog && isNotReleaseVersion) {
                logI(TAG, lpparam.packageName, "Hook Success.");
            }
        } catch (Throwable t) {
            logE(TAG, lpparam.packageName, "Hook Failed", t);
        }
    }

    public void setLoadPackageParam(LoadPackageParam param) {
        lpparam = param;
    }

    public Class<?> findClass(String className) {
        return findClass(className, lpparam.classLoader);
    }

    public Class<?> findClass(String className, ClassLoader classLoader) {
        return XposedHelpers.findClass(className, classLoader);
    }

    public Class<?> findClassIfExists(String className) {
        try {
            return findClass(className);
        } catch (XposedHelpers.ClassNotFoundError e) {
            logE("findClassIfExists", "find " + className + " is Null: " + e);
            return null;
        }
    }

    public Class<?> findClassIfExists(String newClassName, String oldClassName) {
        try {
            return findClass(findClassIfExists(newClassName) != null ? newClassName : oldClassName);
        } catch (XposedHelpers.ClassNotFoundError e) {
            logE("findClassIfExists", "find " + newClassName + " and " + oldClassName + " is Null: " + e);
            return null;
        }
    }

    public Class<?> findClassIfExists(String className, ClassLoader classLoader) {
        try {
            return findClass(className, classLoader);
        } catch (XposedHelpers.ClassNotFoundError e) {
            logE("findClassIfExists", "find " + className + " is Null: " + e);
            return null;
        }
    }

    public static class MethodHook extends XC_MethodHook {

        protected void before(MethodHookParam param) throws Throwable {
        }

        protected void after(MethodHookParam param) throws Throwable {
        }

        public MethodHook() {
            super();
        }

        public MethodHook(int priority) {
            super(priority);
        }


        @Override
        public void beforeHookedMethod(MethodHookParam param) throws Throwable {
            try {
                this.before(param);
            } catch (Throwable t) {
                logE("BeforeHook", t);
            }
        }

        @Override
        public void afterHookedMethod(MethodHookParam param) throws Throwable {
            try {
                this.after(param);
            } catch (Throwable t) {
                logE("AfterHook", t);
            }
        }
    }


    public void findAndHookMethod(Class<?> clazz, String methodName, Object... parameterTypesAndCallback) {
        XposedHelpers.findAndHookMethod(clazz, methodName, parameterTypesAndCallback);
    }

    public void findAndHookMethod(String className, String methodName, Object... parameterTypesAndCallback) {
        findAndHookMethod(findClassIfExists(className), methodName, parameterTypesAndCallback);
    }

    public boolean findAndHookMethodSilently(String className, String methodName, Object... parameterTypesAndCallback) {
        try {
            findAndHookMethod(className, methodName, parameterTypesAndCallback);
            return true;
        } catch (Throwable t) {
            logE("findAndHookMethodSilently", className + methodName + " is null: " + t);
            return false;
        }
    }

    public boolean findAndHookMethodSilently(Class<?> clazz, String methodName, Object... parameterTypesAndCallback) {
        try {
            findAndHookMethod(clazz, methodName, parameterTypesAndCallback);
            return true;
        } catch (Throwable t) {
            logE("findAndHookMethodSilently", clazz + methodName + " is null: " + t);
            return false;
        }
    }

    public void findAndHookConstructor(String className, Object... parameterTypesAndCallback) {
        findAndHookConstructor(findClassIfExists(className), parameterTypesAndCallback);
    }

    public void findAndHookConstructor(Class<?> hookClass, Object... parameterTypesAndCallback) {
        XposedHelpers.findAndHookConstructor(hookClass, parameterTypesAndCallback);
    }

    public void hookMethod(Method method, MethodHook callback) {
        XposedBridge.hookMethod(method, callback);
    }

    public void hookAllMethods(String className, String methodName, XC_MethodHook callback) {
        try {
            Class<?> hookClass = findClassIfExists(className);
            if (hookClass != null) {
                XposedBridge.hookAllMethods(hookClass, methodName, callback).size();
            }

        } catch (Throwable t) {
            logE("HookAllMethods", className + " is " + methodName + " abnormal: " + t);
        }
    }

    public void hookAllMethods(Class<?> hookClass, String methodName, XC_MethodHook callback) {
        try {
            XposedBridge.hookAllMethods(hookClass, methodName, callback).size();
        } catch (Throwable t) {
            logE("HookAllMethods", hookClass + " is " + methodName + " abnormal: " + t);
        }
    }

    public void hookAllMethodsSilently(String className, String methodName, XC_MethodHook callback) {
        try {
            Class<?> hookClass = findClassIfExists(className);
            if (hookClass != null) {
                XposedBridge.hookAllMethods(hookClass, methodName, callback).size();
            }
        } catch (Throwable ignored) {
        }
    }

    public boolean hookAllMethodsSilently(Class<?> hookClass, String methodName, XC_MethodHook callback) {
        try {
            if (hookClass != null) {
                XposedBridge.hookAllMethods(hookClass, methodName, callback).size();
            }
            return false;
        } catch (Throwable t) {
            return false;
        }
    }

    public void hookAllConstructors(String className, MethodHook callback) {
        try {
            Class<?> hookClass = findClassIfExists(className);
            if (hookClass != null) {
                XposedBridge.hookAllConstructors(hookClass, callback).size();
            }
        } catch (Throwable t) {
            logE("hookAllConstructors", className + " is  abnormal: " + t);
        }
    }

    public void hookAllConstructors(Class<?> hookClass, MethodHook callback) {
        try {
            XposedBridge.hookAllConstructors(hookClass, callback).size();
        } catch (Throwable t) {
            logE("hookAllConstructors", hookClass + " is  abnormal: " + t);
        }
    }


    public Object getStaticObjectFieldSilently(Class<?> clazz, String fieldName) {
        try {
            return XposedHelpers.getStaticObjectField(clazz, fieldName);
        } catch (Throwable t) {
            return null;
        }
    }

    public void setDeclaredField(XC_MethodHook.MethodHookParam param, String iNeedString, Object iNeedTo) {
        if (param != null) {
            try {
                Field setString = param.thisObject.getClass().getDeclaredField(iNeedString);
                setString.setAccessible(true);
                try {
                    setString.set(param.thisObject, iNeedTo);
                    Object result = setString.get(param.thisObject);
                    checkLast("getDeclaredField", iNeedString, iNeedTo, result);
                } catch (IllegalAccessException e) {
                    logE("IllegalAccessException to: " + iNeedString + " need to: " + iNeedTo + " code: " + e);
                }
            } catch (NoSuchFieldException e) {
                logE("No such the: " + iNeedString + " code: " + e);
            }
        } else {
            logE("Param is null Field: " + iNeedString + " to: " + iNeedTo);
        }
    }

    public void checkLast(String setObject, Object fieldName, Object value, Object last) {
        if (value.equals(last)) {
            logI(setObject + " Success! set " + fieldName + " to " + value);
        } else {
            logE(setObject + " Failed! set " + fieldName + " to " + value + " hope: " + value + " but: " + last);
        }
    }
}
