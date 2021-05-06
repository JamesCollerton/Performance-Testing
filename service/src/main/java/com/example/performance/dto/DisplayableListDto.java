package com.example.performance.dto;

import lombok.Builder;

import java.util.List;

@Builder
public class DisplayableListDto<T extends Dto> {
    private List<T> items;
}
