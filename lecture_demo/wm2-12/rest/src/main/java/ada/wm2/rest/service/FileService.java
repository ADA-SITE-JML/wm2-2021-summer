package ada.wm2.rest.service;

import ada.wm2.rest.entity.Student;
import ada.wm2.rest.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

@Service
public class FileService {
    @Autowired
    StudentRepository studentRepository;

    String uploadsDir = "/Users/jhasanov/code/wm2/wm2-2021-summer/uploads/";

    public void saveImageFile(String filename, MultipartFile imageFile) {
        try {
            String filePath = uploadsDir + filename;

            File f = new File(filePath);
            if (!f.exists())
                f.createNewFile();

            Files.copy(imageFile.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveImageDB(Integer studentId,MultipartFile imageFile) {
        try {
            Byte[] byteObj = new Byte[imageFile.getBytes().length];
            int i = 0;
            for (byte b : imageFile.getBytes()) {
                byteObj[i++] = b;
            }

            Optional<Student> res = studentRepository.findById(studentId);
            if (res.isPresent()) {
                Student s = res.get();
                s.setProfileImage(byteObj);
                studentRepository.save(s);
            }
        }
        catch (IOException ioex) {
            System.out.println(ioex);
        }

    }
}
