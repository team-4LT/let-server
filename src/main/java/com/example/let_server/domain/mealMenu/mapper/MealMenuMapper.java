package com.example.let_server.domain.mealMenu.mapper;

import com.example.let_server.domain.meal.dto.response.MaxEatersMealWithCountResponse;
import com.example.let_server.domain.meal.dto.response.MealDailyResponse;
import com.example.let_server.domain.mealMenu.domain.MealMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface MealMenuMapper {
    void save(MealMenu mealMenu);

    List<MealMenu> findMonthlyMealMenu(Map<String, Object> params);

    List<MaxEatersMealWithCountResponse> findMaxEatersPerMealType(@Param("year") int year, @Param("month") int month);

    List<MealDailyResponse> findMealDaily(Date today);
}
