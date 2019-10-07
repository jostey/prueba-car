package com.curso.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.curso.dto.ResultRentDto;
import com.curso.exception.NotFoundException;
import com.curso.model.CarEntity;
import com.curso.model.RentEntity;
import com.curso.repository.CarRepository;
import com.curso.repository.RentRepository;
import com.curso.service.mapper.MapperRentDtoToEntity;

@Service
public class RentServiceImpl implements RentService{
	
	@Autowired private RentRepository rentRepository;
	@Autowired private CarRepository carRepository;
	@Autowired private MapperRentDtoToEntity mapperRentDtoToEntity;
	
	private static final String NOT_FOUND_ID_CAR = "No existe el coche con id: ";
	private static final String NOT_FOUND_RENT_CAR = "No hay ningún alquiler asociado en esa fecha para el id de coche: ";
	

	@Override
	public Optional<RentEntity> findById(Integer id) {
		return rentRepository.findById(id);
	}

	@Override
	public Page<RentEntity> findAll(Pageable page) {
		return rentRepository.findAll(page);
	}

	@Override
	public RentEntity save(RentEntity rent) {
		return rentRepository.save(rent);
	}

	@Override
	public void removeById(Integer id) {
		rentRepository.deleteById(id);
	}

	@Override
	public List<RentEntity> findByCar(CarEntity car, LocalDate initDate, LocalDate finalDate) {
		return rentRepository.findByCarAndInitDateGreaterThanEqualAndFinalDateLessThanEqual(car, initDate, finalDate);
	}

	@Override
	public Page<RentEntity> findByUserId(Integer id, Pageable page) {
		return rentRepository.findByUserId(id, page);
	}

	@Override
	public ResultRentDto profitByCarAndDate(Integer carId, Long initDate, Long finalDate) throws NotFoundException {
		CarEntity car = carRepository.findById(carId)
				.orElseThrow(() -> new NotFoundException(NOT_FOUND_ID_CAR + carId));
		
		List<RentEntity> rents = findByCar(car, 
				mapperRentDtoToEntity.LongToLocalDate(initDate), 
				mapperRentDtoToEntity.LongToLocalDate(finalDate));
		
		Double profit = rents.stream().map(x -> x.getPrice()).reduce(0D, Double::sum);
		
		if(profit != 0D) return new ResultRentDto(car.getBrand()+" "+car.getModel(), initDate, finalDate, profit);
		else throw new NotFoundException(NOT_FOUND_RENT_CAR + carId);
	}

}
