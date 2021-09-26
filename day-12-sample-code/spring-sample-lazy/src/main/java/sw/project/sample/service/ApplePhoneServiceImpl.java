package sw.project.sample.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import sw.project.sample.model.Phone;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Lazy
@Primary
@Service("Apple")
public class ApplePhoneServiceImpl implements PhoneServcie  {

    @PostConstruct
    public void init() {
        System.out.println("With @Lazy : ApplePhoneServiceImpl initialize. ");
    }


    private final static List<Phone> phones = new ArrayList<>();

    static {
        phones.add(new Phone().setVendor("Applie")
                .setName("IPhone-5")
                .setDescription("2013 / 09 ")
        );

        phones.add(new Phone().setVendor("Applie")
                .setName("IPhone-6")
                .setDescription("2014")
        );

        phones.add(new Phone().setVendor("Applie")
                .setName("IPhone-7")
                .setDescription("2015")
        );

        phones.add(new Phone().setVendor("Applie")
                .setName("IPhone-8")
                .setDescription("2016")
        );

        phones.add(new Phone().setVendor("Applie")
                .setName("IPhone-9")
                .setDescription("2017")
        );

        phones.add(new Phone().setVendor("Applie")
                .setName("IPhone-10")
                .setDescription("2018")
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
