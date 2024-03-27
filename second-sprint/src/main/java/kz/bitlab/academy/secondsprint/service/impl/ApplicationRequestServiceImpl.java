package kz.bitlab.academy.secondsprint.service.impl;


import kz.bitlab.academy.secondsprint.entity.ApplicationRequest;
import kz.bitlab.academy.secondsprint.repository.ApplicationRepository;
import kz.bitlab.academy.secondsprint.service.ApplicationRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationRequestServiceImpl implements ApplicationRequestService {

    private final ApplicationRepository repository;
    @Transactional
    @Override
    public void create(String userName, String courseName, String phone, String commentary) {
        repository.save(new ApplicationRequest(userName, courseName, phone, commentary));
    }
    @Transactional
    @Override
    public void handle(Long id) {
        ApplicationRequest entity = findById(id);
        entity.setHandled(true);
    }
    @Transactional(readOnly = true)
    @Override
    public List<ApplicationRequest> findAll() {
        return repository.findAll();
    }
    @Transactional(readOnly = true)
    @Override
    public List<ApplicationRequest> findAllNew() {
        return repository.findAll()
                .stream()
                .filter(entity -> !entity.isHandled())
                .toList();
    }
    @Transactional(readOnly = true)
    @Override
    public List<ApplicationRequest> findAllHandled() {
        return repository.findAll()
                .stream()
                .filter(ApplicationRequest::isHandled)
                .toList();
    }

    @Transactional(readOnly = true)
    @Override
    public ApplicationRequest findById(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Application request not found"));
    }

    @Transactional
    @Override
    public void delete(Long id) {
        if(!repository.existsById(id))
            throw new RuntimeException("Application request not found");
        repository.deleteById(id);
    }
}
