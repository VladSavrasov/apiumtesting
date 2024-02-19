package config;

@org.aeonbits.owner.Config.Sources({
        "classpath:${launch}.properties"
})
public interface Config extends org.aeonbits.owner.Config {

    @Key("androidAccessKey")
    String key();

    @Key("androidUserName")
    String user();

    @Key("androidUrl")
    String url();

    @Key("androidDevice")
    String device();
    @Key("androidOsVersion")
    String os();

    @Key("androidApp")
    String app();
}