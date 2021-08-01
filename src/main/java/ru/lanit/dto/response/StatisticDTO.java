package ru.lanit.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatisticDTO {

    Long personcount;
    Long carcount;
    Long uniquevendorcount;
}
