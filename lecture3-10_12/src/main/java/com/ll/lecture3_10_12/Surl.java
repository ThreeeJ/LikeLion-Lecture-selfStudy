package com.ll.lecture3_10_12;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class Surl {
    private long id;
    @Builder.Default
    private LocalDateTime createDate = LocalDateTime.now();
    @Builder.Default
    private LocalDateTime modifyDate = LocalDateTime.now();
    private String body;
    private String url;
    @Setter(AccessLevel.NONE) // 얘는 setter 적용 X
    private long count;

    public void increaseCount() {
        count++;
    }
}
