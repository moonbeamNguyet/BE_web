package net.javaguides.CD_Web_backend.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.CD_Web_backend.dto.ProvincesDto;
import net.javaguides.CD_Web_backend.entity.Provinces;
import net.javaguides.CD_Web_backend.mapper.ProvinceMapper;
import net.javaguides.CD_Web_backend.repository.ProvinceRepository;
import net.javaguides.CD_Web_backend.service.ProvinceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProvinceServiceImpl implements ProvinceService {


    private ProvinceRepository provinceRepository;
    @Override
    public List<ProvincesDto> getAllProvinces() {
        List<Provinces> provinces = provinceRepository.findAll();
        return provinces.stream().map((province) -> ProvinceMapper.maptoProvincesDto(province))
                .collect(Collectors.toList());
    }

}
