package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties"
})

public interface MobileConfig extends Config {

    @Key("platformName")
    String getPlatformName();

    @Key("deviceName")
    String getDeviceName();

    @Key("platformVersion")
    String getPlatformVersion();

    @Key("app")
    String getApp();

    @Key("projectName")
    String getProject();

    @Key("build")
    String getBuild();

    @Key("testName")
    String getTestName();
}
