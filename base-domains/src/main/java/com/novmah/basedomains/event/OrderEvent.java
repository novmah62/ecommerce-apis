package com.novmah.basedomains.event;

import com.novmah.basedomains.dto.OrderDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderEvent implements Serializable {

    private String message;

    private String status;

    private OrderDto orderDto;

}
