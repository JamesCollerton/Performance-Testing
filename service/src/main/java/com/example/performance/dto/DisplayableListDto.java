package com.example.performance.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DisplayableListDto<T extends Dto> {
    private List<T> data;
}
