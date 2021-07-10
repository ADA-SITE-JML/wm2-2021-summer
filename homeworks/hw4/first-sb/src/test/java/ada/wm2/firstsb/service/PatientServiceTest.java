package ada.wm2.firstsb.service;

import ada.wm2.firstsb.entity.Patient;
import ada.wm2.firstsb.repo.PatientRepository;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

    @ExtendWith(MockitoExtension.class)
    class PatientServiceTest {
    @Mock
    PatientRepository patientRepository;

    @InjectMocks
    PatientService patientService;


    @Test
    @DisplayName("Expect to get 2 patients when getPatientList is called ")
    void testGetPatientList(){
    // Given
    Patient ptn1 = new Patient();
    Patient ptn2 = new Patient();
    List<Patient> ptnList = new ArrayList<>();
    ptnList.add(ptn1);
    ptnList.add(ptn2);
    given(patientRepository.findAll()).willReturn(ptnList);

    // When
    List<Patient> allPatients = patientService.getPatientList();

    // Then
    then(patientRepository).should().findAll();
    assertThat(allPatients).hasSize(2);
}




        @Test
        @DisplayName("Expect to get 2 women patients when getPatientList is called ")
        void testGetAllGirls(){
            // Given
            Patient ptn1 = new Patient();
            Patient ptn2 = new Patient();
            List<Patient> ptnList = new ArrayList<>();
            ptnList.add(ptn1);
            ptnList.add(ptn2);
            given(patientRepository.findAllGirls()).willReturn(ptnList);

            // When
            List<Patient> allPatients = patientService.getAllGirls();

            // Then
            then(patientRepository).should().findAllGirls();
            assertThat(allPatients).hasSize(2);
        }



        @Test
        @DisplayName("Find the necessary patient with given id")
        void testGetPatient() {
            // Given
            Patient ptn = new Patient();
            given(patientRepository.findById(anyInt())).willReturn(Optional.of(ptn));

            // When
            Patient found = patientService.getPatient(anyInt());

            // Then
            then(patientRepository).should().findById(anyInt());
            assertThat(found).isNotNull();
        }


        @Test
        @DisplayName("Expect to get the saved patient")
        void testSavePatient() {
            // Given
            Patient ptn = new Patient();
            given(patientRepository.save(ptn)).willReturn(ptn);

            // When
            Patient saved = patientService.savePatient(ptn);

            // Then
            then(patientRepository).should().save(any(Patient.class));
            assertThat(saved).isNotNull();
        }

}
