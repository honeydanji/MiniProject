package com.pethospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pethospital.domain.PetHospital;

public interface PetHospitalRepository extends JpaRepository<PetHospital, Long>{
    @Query("SELECT DISTINCT p.province FROM PetHospital p")
    List<String> findDistinctProvince();

    @Query("SELECT DISTINCT p.city FROM PetHospital p WHERE p.province = ?1")
    List<String> findDistinctCityByProvince(String province);

    @Query("SELECT DISTINCT p.detailcity FROM PetHospital p WHERE p.province = ?1 AND p.city = ?2")
    List<String> findDistinctDetailcityByProvinceAndCity(String province, String city);

 // JPA자동으로 쿼리 생성.. >> 해당 병원 정보를 전부 반환.(정보가 여러개)
    // 상세검색
    List<PetHospital> findByProvince(String province);
    List<PetHospital> findByProvinceAndCity(String province, String city);
    List<PetHospital> findByProvinceAndCityAndDetailcity(String province, String city, String detailcity);
    
    // 병원검색
    List<PetHospital> findByHospitalName(String hospital_name);
}