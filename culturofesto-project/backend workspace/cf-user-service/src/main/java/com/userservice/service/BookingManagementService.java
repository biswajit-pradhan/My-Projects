package com.userservice.service;

import java.util.List;

public interface BookingManagementService {

	List<Long> getAllRegestdEventsBuUserId(Long userId);
	
	public String cancelEventById(Long userId, Long eventId);

}
