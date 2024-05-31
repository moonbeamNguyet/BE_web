package net.javaguides.CD_Web_backend.service;

import net.javaguides.CD_Web_backend.dto.DistrictsDto;

import java.util.List;

public interface DistrictsService {

    List<DistrictsDto> getDistrictsByProvinceID(Long provinceID);



}
