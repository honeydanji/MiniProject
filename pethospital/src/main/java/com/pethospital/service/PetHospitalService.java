package com.pethospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pethospital.domain.PetHospital;
import com.pethospital.repository.PetHospitalRepository;

@Service
public class PetHospitalService {

    @Autowired
    private PetHospitalRepository pet_hospital_Repository;

    public List<String> getDistinctProvinces() {
        return pet_hospital_Repository.findDistinctProvince();
    }

    public List<String> getDistinctCitiesByProvince(String province) {
        return pet_hospital_Repository.findDistinctCityByProvince(province);
    }

    public List<String> getDistinctDetailCitiesByProvinceAndCity(String province, String city) {
        return pet_hospital_Repository.findDistinctDetailcityByProvinceAndCity(province, city);
    }

    // 검색
    public List<PetHospital> getpethospitalByName(String name) {
        if (name == null) {
            return null;
        }else {
            return pet_hospital_Repository.findByHospitalName(name);
        }
    }


    // 상세검색 >> 광역도시 : 병원
    public List<PetHospital> getpethospitalByProvince(String province) {
        return pet_hospital_Repository.findByProvince(province);
    }

    // 상세검색 >> 광역도시 >> 시군구 :병원
    public List<PetHospital> getpethospitalByProvinceAndCity(String province, String city) {
        return pet_hospital_Repository.findByProvinceAndCity(province, city);
    }

    // 상세검색 >> 광역도시 >> 시군구 >> 읍면동 : 병원
    public List<PetHospital> getpethospitalByProvinceAndCityAndDetailCity(String province, String city, String detailcity) {
        return pet_hospital_Repository.findByProvinceAndCityAndDetailcity(province, city, detailcity);
    }
}