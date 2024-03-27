package kz.bitlab.academy.secondsprint.service;

import kz.bitlab.academy.secondsprint.entity.ApplicationRequest;

import java.util.List;

public interface ApplicationRequestService {

    void create(String userName, String courseName, String phone, String commentary);

    void handle(Long id);

    List<ApplicationRequest> findAll();

    List<ApplicationRequest> findAllNew();

    List<ApplicationRequest> findAllHandled();

    ApplicationRequest findById(Long id);

    void delete(Long id);

}
