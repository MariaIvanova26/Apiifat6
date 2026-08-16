package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CurrenciesNaming {
        USD("USD"),
        EUR("EUR"),
        RUB("RUB");
        private final String displayName;
}
