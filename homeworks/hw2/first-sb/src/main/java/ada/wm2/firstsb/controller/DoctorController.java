package ada.wm2.firstsb.controller;

import ada.wm2.firstsb.entity.Doctor;
import ada.wm2.firstsb.entity.Patient;
import ada.wm2.firstsb.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;



//if id is even doctors work at night, is odd doctors work at morning
//    @GetMapping("/girls")
//    public String getDoctorByNameOr(Model model){
//        List<Doctor> doctorList = doctorService.getAllGirls();
//        model.addAttribute("doctors", doctorList);
//        return "doctor_list";
//    }





//    @GetMapping("/and/{firstName}/{lastName}")
//    public String getPatientByName(Model model, @PathVariable String firstName, @PathVariable String lastName){
//        Doctor dr = doctorService.getByNameAndSurname(firstName, lastName);
//        model.addAttribute("doctor", dr);
//        return "doctor_data";
//    }
//
//    @GetMapping("/or/{firstName}/{lastName}")
//    public String getPatientByNameOr(Model model, @PathVariable String firstName, @PathVariable String lastName){
//        List<Doctor> doctorList = doctorService.getByNameOrSurname(firstName,lastName);
//        model.addAttribute("doctors", doctorList);
//        return "doctor_list";
//    }

//    @GetMapping("/{doctorId}")
//    public  String getDoctor(Model model, @PathVariable Integer doctorId){
//        Doctor dr = doctorService.getDoctor(doctorId);
//        model.addAttribute("doctor", dr);
//        return "doctor_data";
//
//    }






    //adding
    @GetMapping("/new")
    public  String showEditForm(Model model){
        model.addAttribute("doctor", new Doctor());
        return "doctor_form";

    }
    //edit
    @GetMapping("/edit/doctorId}")
    public  String showEditForm(Model model, @PathVariable Integer doctorId){
        Doctor dr = doctorService.getDoctor(doctorId);

        model.addAttribute("patient", dr);
        return "doctor_form";

    }

    //save
    @PostMapping("/save")
    public String showEditForm(Model model,Doctor dr) {
        Doctor updDr = doctorService.saveDoctor(dr);

        model.addAttribute("doctor",updDr);
        return "doctor_data";
    }











    @GetMapping("/list")
    public String getDoctorList(Model model) {
        List<Doctor> doctorList = doctorService.getDoctorList();

        model.addAttribute("doctors",doctorList);
        return "doctor_list";
    }
}
