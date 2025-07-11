package com.example.let_server.domain.menuRank.mapper;

import com.example.let_server.domain.menuRank.dto.response.MenuRankingDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface MenuRankMapper {
    void updateMenuScoreByWilson();
    List<MenuRankingDto> findAllOrderByScoreDesc();
    void saveMenuRankHistory(@Param("menuId") Long menuId, @Param("date") Date date, @Param("rank") int rank, @Param("rankDiff") int rankDiff);
    Integer getRankDiff(Long menuId,Date date);
}
