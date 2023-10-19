package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties"
})

public interface MobileConfig extends Config {

    @Key("platformName")
    @DefaultValue("android")
    String getPlatformName();

    @Key("device")
    @DefaultValue("Samsung Galaxy S22 Ultra")
    String getDeviceName();

    @Key("os_version")
    @DefaultValue("12.0")
    String getVersion();

    @Key("app")
    @DefaultValue("bs://sample.app")
    String getApp();

    @Key("projectName")
    @DefaultValue("First Java Project")
    String getProject();

    @Key("build")
    @DefaultValue("browserstack-build-1")
    String getBuild();

    @Key("testName")
    @DefaultValue("android_test")
    String getTestName();
}
