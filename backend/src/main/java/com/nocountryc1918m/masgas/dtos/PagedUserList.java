package com.nocountryc1918m.masgas.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PagedUserList {
    private List users;
    private Long total_results;
    private Integer results_per_page;
    private Integer current_page;
    private Integer pages;
    private String sort_by;
}
