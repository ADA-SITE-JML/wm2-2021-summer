package ada.wm2.carrental.service;

import ada.wm2.carrental.bean.CarBean;
import ada.wm2.carrental.entity.Car;
import ada.wm2.carrental.repo.CarRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
public class CarServiceTest
{
    @Mock
    CarRepository carRepository;

    @InjectMocks
    CarService carService;

    @Test
    @DisplayName("Should return car bean")
    void testGetCarById()
    {
        Car car = new Car();
        given(carRepository.findById(anyInt())).willReturn(Optional.of(car));
        CarBean found = carService.getCarById(anyInt());
        then(carRepository).should().findById(anyInt());
        assertThat(found).isNotNull();
    }

    @Test
    @DisplayName("Should return car bean list")
    void testGetCarList()
    {
        Car car1 = new Car();
        Car car2 = new Car();
        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        given(carRepository.findAll()).willReturn(carList);
        List<CarBean> found = carService.getCarList();
        then(carRepository).should().findAll();
        assertThat(found).hasSize(2);
    }

}
