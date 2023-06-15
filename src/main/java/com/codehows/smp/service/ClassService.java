package com.codehows.smp.service;

import com.codehows.smp.dto.SeatDto;
import com.codehows.smp.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ClassService {

    private final StudentRepository studentRepository;

    public List<SeatDto> getSeatsList(String classAB) {
        return studentRepository.findSeatDtoList(classAB);
    }

    public Long addImg(Long studentId, MultipartFile imgFile) throws IOException {
        // 2. 서버에 파일 저장 & DB에 파일 정보(fileinfo) 저장
        // - 동일 파일명을 피하기 위해 random값 사용
        String originalFilename = imgFile.getOriginalFilename();
        String saveFileName = createSaveFileName(originalFilename);

        // 2-1.서버에 파일 저장
        imgFile.transferTo(new File(getFullPath(saveFileName)));

        // 2-2. DB에 정보 저장
        String contentType = imgFile.getContentType();

        FileInfoRegister fileInfoRegister = FileInfoRegister.builder()
                .fileName(originalFilename)
                .saveFileName(saveFileName)
                .contentType(contentType)
                .deleteFlag(notDeleted).build();

        int fileInfoId = fileInfoDao.insert(fileInfoRegister);
    }
    ///////////////////////////////////////////////////////////////////////////////

        // 파일 저장 이름 만들기
    // - 사용자들이 올리는 파일 이름이 같을 수 있으므로, 자체적으로 랜덤 이름을 만들어 사용한다
    private String createSaveFileName(String originalFilename) {
        String ext = extractExt(originalFilename);
        String uuid = UUID.randomUUID().toString();
        return uuid + "." + ext;
    }

    // 확장자명 구하기
    private String extractExt(String originalFilename) {
        int pos = originalFilename.lastIndexOf(".");
        return originalFilename.substring(pos + 1);
    }

    // fullPath 만들기
    private String getFullPath(String filename) {
        return uploadPath + filename;
    }

}
