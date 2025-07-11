package com.example.let_server.domain.menuRank.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MenuRankingDto {
    private Long menuId;
    private String menuName;
    private double menuScore;
    private Integer currentRank;
}
