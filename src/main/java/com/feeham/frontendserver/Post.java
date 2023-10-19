package com.feeham.frontendserver;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor @Getter @Setter
public class Post {
    private Integer id;
    private String title;
    private String body;
    private String postedBy;
    private LocalDateTime postTime;
    private Integer reactions;
}
