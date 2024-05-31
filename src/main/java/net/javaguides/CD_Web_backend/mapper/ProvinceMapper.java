package net.javaguides.CD_Web_backend.mapper;

import net.javaguides.CD_Web_backend.dto.ProvincesDto;
import net.javaguides.CD_Web_backend.entity.Provinces;

public class ProvinceMapper {

    public static ProvincesDto maptoProvincesDto(Provinces provinces){
        return new ProvincesDto(
                provinces.getProvinceID(),
                provinces.getProvinceName(),
                provinces.getType()
        );
    }
}
