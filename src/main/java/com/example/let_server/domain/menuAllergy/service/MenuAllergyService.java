package com.example.let_server.domain.menuAllergy.service;


import com.example.let_server.domain.allergy.dto.response.AllergyResponse;

import java.util.List;

public interface MenuAllergyService {
    void save(Long menuId, Long allergyId);
    List<AllergyResponse> getAllergyByMealId(Integer mealId);
    void saveAllBatch(Long menuId, List<Long> allergyIds);
}
