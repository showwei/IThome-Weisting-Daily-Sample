package sw.spring.sample.model;

import sw.spring.sample.enums.LanguageEunm;

public class MovieCandidate {

    String name;

    StringBuffer description;

    LanguageEunm lang;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StringBuffer getDescription() {
        return description;
    }

    public void setDescription(StringBuffer description) {
        this.description = description;
    }

    public LanguageEunm getLang() {
        return lang;
    }

    public void setLang(LanguageEunm lang) {
        this.lang = lang;
    }
}
