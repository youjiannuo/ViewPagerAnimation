package com.app.myapplicationtest;

import com.yn.framework.system.YNApplication;

/**
 * Created by youjiannuo on 2019/2/25.
 * Email by 382034324@qq.com
 */
public class MyApplication extends YNApplication {
    @Override
    public String getHost() {
        return null;
    }

    @Override
    public boolean getEnvironment() {
        return BuildConfig.ENVIRONMENT;
    }

    @Override
    public String getApplicationId() {
        return BuildConfig.APPLICATION_ID;
    }

    @Override
    public String getVersionName() {
        return BuildConfig.VERSION_NAME;
    }

    @Override
    public String getVersionCode() {
        return String.valueOf(BuildConfig.VERSION_CODE);
    }


    @Override
    public String getHost1() {
        return null;
    }
}
