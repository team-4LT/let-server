package com.example.let_server.domain.meal.dto.response;


import com.example.let_server.domain.meal.domain.Meal;
import com.example.let_server.domain.meal.domain.MealType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MealWithOutMenusResponse {
    private int mealId;
    private Date mealDate;
    private MealType mealType;
    private float calorie;

    public static MealWithOutMenusResponse of(Meal meal) {
        return MealWithOutMenusResponse.builder()
                .mealId(meal.getMealId())
                .mealDate(meal.getMealDate())
                .mealType(meal.getMealType())
                .calorie(meal.getCalorie())
                .build();
    }
}
