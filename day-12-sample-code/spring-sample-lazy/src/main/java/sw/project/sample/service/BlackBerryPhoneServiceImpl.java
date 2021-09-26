package sw.project.sample.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import sw.project.sample.model.Phone;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Lazy
@Service("BlackBerry")
public class BlackBerryPhoneServiceImpl implements PhoneServcie {

    @PostConstruct
    public void init() {
        System.out.println("With @Lazy : BlackBerryPhoneServiceImpl initialize. ");
    }

    private final static List<Phone> phones = new ArrayList<>();

    static {
        phones.add(new Phone().setVendor("BlackBerry")
                .setName("KEY2 LE")
                .setDescription("2019")
        );

        phones.add(new Phone().setVendor("BlackBerry")
                .setName("Bold 9700")
                .setDescription("2009")
        );

    }

    @Override
    public List<Phone> listAllPhone() {
        return phones;
    }

    @Override
    public Phone getPhoneByModel(String model) {
        return phones
                .stream()
                .filter(phone -> phone.getName().equalsIgnoreCase(model))
                .findFirst()
                .orElse(null);
    }
}
