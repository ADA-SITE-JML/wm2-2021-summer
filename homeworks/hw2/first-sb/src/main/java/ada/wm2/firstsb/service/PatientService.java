package ada.wm2.firstsb.service;

import ada.wm2.firstsb.bean.PatientBean;
import ada.wm2.firstsb.entity.Patient;
import ada.wm2.firstsb.repo.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;


    public  List<Patient> getAllGirls( ){
        List<Patient> patientList = (List<Patient>) patientRepository.findAllGirls();
        return patientList;

    }




    public Patient getByNameAndSurname(String first, String last ){
        Optional<Patient> ptn = patientRepository.findByFirstNameAndLastName(first,last);
        if(ptn.isPresent())
            return ptn.get();
        else
            return  new Patient();
    }

public  List<Patient> getByNameOrSurname(String first, String last ){
        List<Patient> patientList = (List<Patient>) patientRepository.findByFirstNameOrLastName(first,last);
        return patientList;

}


    public Patient getPatient(Integer patientId){
        Optional<Patient> ptn = patientRepository.findById(patientId);
        if(ptn.isPresent())
            return ptn.get();
        else
           return  new Patient();
    }

    public List<Patient> getPatientList(){
        List<Patient> patientList = (List<Patient>) patientRepository.findAll();

        return patientList;
    }

    public  Patient savePatient(Patient ptn) {
        Patient savedPtn =  patientRepository.save(ptn);
        return savedPtn;

    }

}
