package com.example.task1.peliod;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OutputDTO {
    private Date date;
    private Integer warehouseId, clientId, currencyId;
    private List<OutputProductDTO> outputProductDTOList;
}
