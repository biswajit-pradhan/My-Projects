package com.adminservice.dto;

import com.adminservice.entity.Event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDataDTO {
	
	private Event event;
    private byte[] imageData;
    
}
