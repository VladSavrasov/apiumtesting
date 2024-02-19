package config;

@org.aeonbits.owner.Config.Sources({
        "classpath:${launch}.properties"
})
public interface Config extends org.aeonbits.owner.Config {

    @Key("accessKey")
    String key();

    @Key("userName")
    String user();

    @Key("url")
    String url();

    @Key("device")
    String device();
    @Key("osVersion")
    String os();

    @Key("app")
    String app();
}