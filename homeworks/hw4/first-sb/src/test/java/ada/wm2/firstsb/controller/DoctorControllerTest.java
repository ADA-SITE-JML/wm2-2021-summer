package ada.wm2.firstsb.controller;

import ada.wm2.firstsb.service.DoctorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Map;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)

public class DoctorControllerTest {
    @Mock
    DoctorService doctorService;
    @Mock
    Map<String, Object> model;

    @InjectMocks
    DoctorController controller;

    MockMvc mockMvc;


    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    @DisplayName("New form shall return doctor_form")
    void testNewForm() throws Exception {
        mockMvc.perform(get("/doctor/new"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("doctor"))
                .andExpect(view().name("doctor_form"));
    }


    @Test
    @DisplayName("List all the doctor data")
    void testGetDoctorList() throws Exception {

        mockMvc.perform(get("/doctor/list"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("doctors"))
                .andExpect(view().name("doctor_list"));
    }

    @Test
    @DisplayName("Edit form ")
    void testEditForm() throws Exception {

        mockMvc.perform(get("/doctor/edit/{doctorId}", anyInt()))
                .andExpect(status().isOk());

    }





}
