package com.example.let_server.domain.menuRank.service.impl;

import com.example.let_server.domain.menu.repository.MenuRepository;
import com.example.let_server.domain.menuRank.dto.response.MenuRankingDto;
import com.example.let_server.domain.menuRank.repository.MenuRankRepository;
import com.example.let_server.domain.menuRank.service.MenuRankService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MenuRankServiceImpl implements MenuRankService {

    private final MenuRankRepository menuRankRepository;
    private final MenuRepository menuRepository;

    @Scheduled(cron = "0 0 0 * * *")
    private void updateMenuScoreByWilson() {
        menuRankRepository.updateMenuScoreByWilson();
        List<MenuRankingDto> rankedMenus = getMenuRankings();

        for (int i = 0; i < rankedMenus.size(); i++) {
            MenuRankingDto dto = rankedMenus.get(i);
            int newRank = i + 1;
            int oldRank = dto.getCurrentRank() != null ? dto.getCurrentRank() : newRank;

            // 순위 바뀐 경우만 기록
            if (oldRank != newRank) {
                int rankDiff = oldRank - newRank;

                // Menu 테이블 current_rank 업데이트
                menuRepository.updateCurrentRank(dto.getMenuId(), newRank);

                // MenuRankHistory 저장
                Date today = getToday();
                menuRankRepository.saveMenuRankHistory(dto.getMenuId(), today, newRank, rankDiff);

        }
        }
    }

    private Date getToday() {
        return Date.valueOf(LocalDate.now());
    }

    @Override
    public List<MenuRankingDto> getMenuRankings() {
        return menuRankRepository.findAllOrderByScoreDesc();
    }

    @Override
    public Integer getRankDiff(Long menuId) {
        Date today = getToday();
        Integer result = menuRankRepository.getRankDiff(menuId, today);
        return (result != null) ? result : 0;
    }
}
