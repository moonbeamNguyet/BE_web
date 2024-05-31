package net.javaguides.CD_Web_backend.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.CD_Web_backend.dto.DistrictsDto;
import net.javaguides.CD_Web_backend.entity.Districts;
import net.javaguides.CD_Web_backend.mapper.DistrictsMapper;
import net.javaguides.CD_Web_backend.repository.DistrictsRepository;
import net.javaguides.CD_Web_backend.service.DistrictsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DistrictsServiceImpl implements DistrictsService {
    private DistrictsRepository districtsRepository;

    @Override
    public List<DistrictsDto> getDistrictsByProvinceID(Long provinceID) {
        List<Districts> districts = districtsRepository.findByProvinceID(provinceID);
        if (districts.isEmpty()) {
            return null;
        }
        return districts.stream()
                .map(DistrictsMapper::maptoDistrictsDto)
                .collect(Collectors.toList());
    }
}

