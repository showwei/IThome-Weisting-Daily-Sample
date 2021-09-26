package sw.project.sample.service;

import org.springframework.stereotype.Service;
import sw.project.sample.model.Phone;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service("Android")
public class AndroidPhoneServiceImpl implements PhoneServcie  {

    @PostConstruct
    public void init() {
        System.out.println("Without @Lazy : AndroidPhoneServiceImpl initialize. ");
    }

    private final static List<Phone> phones = new ArrayList<>();

    static {
        phones.add(new Phone().setVendor("Samsung")
                .setName("Galaxy-S21")
                .setDescription("2021")
        );

        phones.add(new Phone().setVendor("Samsung")
                .setName("Galaxy-S21+")
                .setDescription("2021")
        );

        phones.add(new Phone().setVendor("HTC")
                .setName("U20")
                .setDescription("2020")
        );

        phones.add(new Phone().setVendor("HTC")
                .setName("Desire 20")
                .setDescription("2020")
        );

        phones.add(new Phone().setVendor("OPPO")
                .setName("Reno6-Z")
                .setDescription("2021")
        );

        phones.add(new Phone().setVendor("OPPO")
                .setName("Reno4-Z")
                .setDescription("2020")
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
