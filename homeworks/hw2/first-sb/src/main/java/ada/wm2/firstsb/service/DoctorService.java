package ada.wm2.firstsb.service;

import ada.wm2.firstsb.entity.Doctor;

import ada.wm2.firstsb.entity.Patient;
import ada.wm2.firstsb.repo.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired

//


//
//    public Doctor getByNameAndSurname(String first, String last ){
//        Optional<Doctor> dr = doctorRepository.findByFirstNameAndLastName(first,last);
//        if(dr.isPresent())
//            return dr.get();
//        else
//            return  new Doctor();
//    }
//
//    public  List<Doctor> getByNameOrSurname(String first, String last ){
//        List<Doctor> doctorList = (List<Doctor>) doctorRepository.findByFirstNameOrLastName(first,last);
//        return doctorList;
//
//    }


    public Doctor getDoctor(Integer doctorId){
        Optional<Doctor> dr = doctorRepository.findById(doctorId);
        if(dr.isPresent())
            return dr.get();
        else
            return  new Doctor();
    }

//












    DoctorRepository doctorRepository;
    public List<Doctor> getDoctorList(){
        List<Doctor> doctorList = (List<Doctor>) doctorRepository.findAll();

        return doctorList;
    }


    public  Doctor saveDoctor(Doctor dr) {
        Doctor savedDr =  doctorRepository.save(dr);
        return savedDr;

    }

}
