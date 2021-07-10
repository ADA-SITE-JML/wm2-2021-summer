//package ada.wm2.firstsb.controller;
//
//public class PatientControllerTest {
//}
package ada.wm2.firstsb.controller;

import ada.wm2.firstsb.entity.Patient;
import ada.wm2.firstsb.service.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)

public class PatientControllerTest {
    @Mock
    PatientService patientService;
    @Mock
    Map<String, Object> model;

    @InjectMocks
    PatientController controller;

    MockMvc mockMvc;


    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    @DisplayName("New form shall return patient_form")
    void testNewForm() throws Exception {
        mockMvc.perform(get("/patient/new"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("patient"))
                .andExpect(view().name("patient_form"));
    }




        @Test
    @DisplayName("List All Patient Data")
    void testGetPatientList() throws Exception {

        mockMvc.perform(get("/patient/list"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("patients"))
                .andExpect(view().name("patient_list"));
    }






    @Test
//    @DisplayName("Edit Form")
    void testEditForm() throws Exception {

        mockMvc.perform(get("/patient/edit/{patientId}", anyInt()))
                .andExpect(status().isOk());

    }


    @Test
    @DisplayName("Save edited form shall return patient_form")
    void testSaveForm() throws Exception {

        mockMvc.perform(post("/patient/save"))
                .andExpect(status().isOk())
                .andExpect(view().name("patient_form"));

    }


}
