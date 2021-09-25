package sw.spring.sample.enums;

public enum LanguageEunm {
    EN("English","EN"),
    CN("Chinese","CH"),
    TW("Chinese","TW");

    String name;
    String code;

    LanguageEunm(String name,String code) {
        this.name = name;
        this.code = code;
    }
}
