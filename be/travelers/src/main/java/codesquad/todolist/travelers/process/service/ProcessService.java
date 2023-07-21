package codesquad.todolist.travelers.process.service;

import static codesquad.todolist.travelers.global.ErrorCode.FAIL_PROCESS_CREATE;
import static codesquad.todolist.travelers.global.ErrorCode.NOT_EXIST_PROCESS;

import codesquad.todolist.travelers.global.CustomException;
import codesquad.todolist.travelers.process.domain.dto.ProcessRequestDto;
import codesquad.todolist.travelers.process.domain.entity.Process;
import codesquad.todolist.travelers.process.repository.ProcessRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ProcessService {

    private final ProcessRepository processRepository;

    public ProcessService(ProcessRepository processRepository) {
        this.processRepository = processRepository;
    }

    public Long saveProcess(ProcessRequestDto processRequestDto) {
        Process process = ProcessRequestDto.toEntity(processRequestDto);
        return processRepository.createProcess(process).orElseThrow(
                () -> new CustomException(FAIL_PROCESS_CREATE));
    }

    public void updateProcess(ProcessRequestDto processRequestDto, Long processId) {
        Process process = processRepository.findProcessById(processId).orElseThrow(
                () -> new CustomException(NOT_EXIST_PROCESS));
        processRepository.updateProcess(process.update(processRequestDto.getProcessName()));
    }

    public void deleteProcess(Long processId) {
        processRepository.findProcessById(processId).orElseThrow(
                () -> new CustomException(NOT_EXIST_PROCESS));
        processRepository.deleteProcess(processId);
    }

    public String findProcessName(Long processId) {
        return processRepository.findProcessNameBy(processId);
    }
}
