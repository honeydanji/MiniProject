package com.pethospital.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pethospital.service.PetHospitalService;

@RestController
public class PetController {
    
    @Autowired
    private PetHospitalService petHospitalService;

    @GetMapping("/province") 
    public Map<String, Object> getProvinces() {
        Map<String, Object> response = new HashMap<>();
        response.put("province", petHospitalService.getDistinctProvinces()); // 광역도시 반환
        return response;
    }

    // '광역도시'에 속한 '시/군/구' 반환
    @GetMapping("/province/{province}")
    public Map<String, Object> getProvinces(@PathVariable String province) {
        Map<String, Object> response = new HashMap<>();
        response.put("sigungu", petHospitalService.getDistinctCitiesByProvince(province)); // 시/구/군 반환
        return response;
    }

    // '광역도시'에 속한 '시/군/구'에 속한 동/읍/면 반환
    @GetMapping("/province/{province}/{sigungu}")
    public Map<String, Object> getProvinces(@PathVariable String province, @PathVariable String sigungu) {
        Map<String, Object> response = new HashMap<>();
        response.put("dong", petHospitalService.getDistinctDetailCitiesByProvinceAndCity(province, sigungu)); // 동/읍/면 반환
        return response;
    }
      
    // 검색 동물병원 반환 > 검색
    @GetMapping("/searchhospital/{name}")
    public Map<String, Object> getHospitalOfName(@PathVariable String name) {
        Map<String, Object> response = new HashMap<>();
        response.put("hospital_name", petHospitalService.getpethospitalByName(name)); // 검색을 통한 동물병원
        return response;
    }
    
     // 상세검색
     // '광역도시'에 속한 동물병원 반환
     @GetMapping("/hospital/{province}")
     public Map<String, Object> getHospitalOfProvinces(@PathVariable String province){
         Map<String, Object> response = new HashMap<>();
         response.put("pethospital", petHospitalService.getpethospitalByProvince(province)); // 광역도시 병원목록
         return response;
     }
     
     // '광역도시' 에 속하고 '시군구' 속한 동물병원 반환
     @GetMapping("/hospital/{province}/{city}")
     public Map<String, Object> getHospitalOfCities(@PathVariable String province, 
    		 										@PathVariable String city) {
         Map<String, Object> response = new HashMap<>();
         response.put("pethospital", petHospitalService.getpethospitalByProvinceAndCity(province, city)); // 도/시 + 시/구/군 병원목록
         return response;
     }
     
     // '광역도시' 에 속한 '시군구'에 속한 '동읍면' 에 속한 동물병원 반환
     @GetMapping("/hospital/{province}/{city}/{detailcity}")
     public Map<String, Object> getHospitalOfDetailCities(@PathVariable String province, 
    		 											  @PathVariable String city, 
    		 											  @PathVariable String detailcity){
         Map<String, Object> response = new HashMap<>();
         response.put("pethospital", petHospitalService.getpethospitalByProvinceAndCityAndDetailCity(province, city, detailcity));// 도/시 + 시/구/군 + 동/읍/면 병원목록
         return response;
     }
}
