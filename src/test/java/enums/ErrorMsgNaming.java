package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMsgNaming {
    PARAMETER_IS_NOT_DISPLAYED("Необходимое поле отсутствует.");
    private final String displayName;
}
