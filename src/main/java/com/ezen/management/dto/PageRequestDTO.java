package com.ezen.management.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageRequestDTO {

//    기본값: null이면 1페이지
    @Builder.Default
    private int page = 1;

//    기본값: null이면 10개씩
    @Builder.Default
    private int size = 10;

//    검색 카테고리
    private String type;

//    검색 키워드
    private String keyword;

    private String link;

    public Pageable getPageable(String...props){
        return PageRequest.of(this.page -1, this.size, Sort.by(props).descending());
    }

    public String[] getTypes(){
        if(type == null || type.isEmpty()){
            return null;
        }

        return type.split("");
    }

    public String getLink(){

        StringBuilder sb = new StringBuilder();

        if(link == null){
            sb.append("page=").append(this.page)
                    .append("&size=").append(this.size);
        }

        if(type != null && type.length() > 0){
            sb.append("&type=").append(type);
        }

        if(keyword != null){
            sb.append("&keyword=").append(URLEncoder.encode(this.keyword, StandardCharsets.UTF_8));
        }

        return sb.toString();
    }





}
