package com.ezen.management.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionDTO {

    private Long idx;
    private String name;
    private String content;
    private String example;
    private String uuid;
    private String fileName;
    private String extension;
    private int number;
    private String item1;
    private String item2;
    private String item3;
    private String item4;

    private int answer;

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getExtension() {
        return extension;
    }
}
