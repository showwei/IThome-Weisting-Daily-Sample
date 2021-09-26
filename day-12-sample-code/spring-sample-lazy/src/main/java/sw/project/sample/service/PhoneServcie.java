package sw.project.sample.service;

import sw.project.sample.model.Phone;

import java.util.List;

public interface PhoneServcie {
    List<Phone> listAllPhone();
    Phone getPhoneByModel(String model);
}
