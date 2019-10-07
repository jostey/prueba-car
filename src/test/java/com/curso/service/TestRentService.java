package com.curso.service;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.curso.exception.NotFoundException;
import com.curso.repository.CarRepository;
import com.curso.repository.RentRepository;

import org.junit.Assert;

import com.curso.model.*;

@RunWith(MockitoJUnitRunner.class)
public class TestRentService {
	@InjectMocks private RentServiceImpl rentService;
	@Mock private CarRepository carRepository;
	@Mock private RentRepository rentRepository;
	
	@Test(expected = NotFoundException.class)
	public void whenCarIdNotExistThrowNotFoundException () throws NotFoundException{
		//Given
		final Integer carId = 100;
		final Long initDate = 1L;
		final Long finalDate = 2L;
		final CarEntity car = new CarEntity(carId, null, null, null, null);
		
		// When
		Mockito.doThrow(new NotFoundException())
			.when(rentRepository).findByCarAndInitDateGreaterThanEqualAndFinalDateLessThanEqual(car, LocalDate.ofEpochDay(initDate), LocalDate.ofEpochDay(finalDate));
		
		rentService.profitByCarAndDate(carId, initDate, finalDate);
	}
}
