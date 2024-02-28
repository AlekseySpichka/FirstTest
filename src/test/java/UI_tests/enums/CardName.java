package UI_tests.enums;

import lombok.Getter;

@Getter
public enum CardName {

    STREAMING_DATA(0, "Потоковая передача данных"),
    DATABASE(1, "База данных"),
    STRUCTURED_FORMAT(2, "Структурированный формат"),
    UNSTRUCTURED_FORMAT(3, "Неструктурированный формат"),
    SPECIALIZED_FORMAT(4, "Специализированный формат");

    private final int index;
    private final String text;

    CardName(int index, String text) {
        this.index = index;
        this.text = text;
    }
}
