package ada.wm2.firstsb.controller;

import ada.wm2.firstsb.entity.Patient;
import ada.wm2.firstsb.service.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/patient")
public class PatientController {
    Logger log = LoggerFactory.getLogger("PatientController");



    @Autowired
    PatientService patientService;

    //adding
    @GetMapping("/new")
    public  String newForm(Model model){
        model.addAttribute("patient", new Patient());
        return "patient_form";

    }
    //edit
    @GetMapping("/edit/{patientId}")
    public  String EditForm(Model model, @PathVariable Integer patientId){
        Patient ptn = patientService.getPatient(patientId);

        model.addAttribute("patient", ptn);
        return "patient_form";

    }

//save
@PostMapping("/save")
public String saveForm(Model model, @Valid Patient ptn, BindingResult bindingResult) {

if(bindingResult.hasErrors()){
    log.error("There are validation errors");

    return  "patient_form";
}
    Patient updPtn = patientService.savePatient(ptn);
    log.info("Patient information saved successfully!");


//    model.addAttribute("patient",updPtn);
//    return "patient_data";



    return "redirect:/patient/list";
}




//@GetMapping

    @GetMapping("/girls")
    public String getPatientByNameOr(Model model){
        List<Patient> patientList = patientService.getAllGirls();
        model.addAttribute("patients", patientList);
        return "patient_list";
    }





    @GetMapping("/and/{firstName}/{lastName}")
    public String getPatientByName(Model model, @PathVariable String firstName, @PathVariable String lastName){
        Patient ptn = patientService.getByNameAndSurname(firstName, lastName);
        model.addAttribute("patient", ptn);
        return "patient_data";
    }

    @GetMapping("/or/{firstName}/{lastName}")
    public String getPatientByNameOr(Model model, @PathVariable String firstName, @PathVariable String lastName){
        List<Patient> patientList = patientService.getByNameOrSurname(firstName,lastName);
        model.addAttribute("patients", patientList);
        return "patient_list";
    }



    @GetMapping("/{patientId}")
public  String getPatient(Model model, @PathVariable Integer patientId){
    Patient ptn = patientService.getPatient(patientId);
    model.addAttribute("patient", ptn);
    return "patient_data";

}
    @GetMapping("/list")


    public String getPatientList(Model model){

        List<Patient> patientList = patientService.getPatientList();
        model.addAttribute("patients", patientList);
        return "patient_list";
    }

}
