package com.example.performance.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto implements Dto {
    private String name;
}
