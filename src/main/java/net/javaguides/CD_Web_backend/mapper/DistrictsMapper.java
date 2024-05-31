package net.javaguides.CD_Web_backend.mapper;

import net.javaguides.CD_Web_backend.dto.DistrictsDto;
import net.javaguides.CD_Web_backend.entity.Districts;

public class DistrictsMapper {
    public  static DistrictsDto maptoDistrictsDto(Districts districts){
        return new DistrictsDto(
                districts.getDistrictID(),
                districts.getDistrictName(),
                districts.getType(),
                districts.getProvinceID()
        );
    }
}
