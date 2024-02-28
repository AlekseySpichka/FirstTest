package UI_tests.enums;

import lombok.Getter;

@Getter
public enum SourceName {

    STREAMING_DATA("map"),
    DATABASE("db"),
    STRUCTURED_FORMAT("sf"),
    UNSTRUCTURED_FORMAT("uf"),
    SPECIALIZED_FORMAT("las");

    private final String prefix;

    SourceName(String prefix) {
        this.prefix = prefix;
    }
}
