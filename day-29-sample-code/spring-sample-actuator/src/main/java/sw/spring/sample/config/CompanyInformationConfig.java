package sw.spring.sample.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Configuration
@ConfigurationProperties(
        prefix = "sea.food.company",
        ignoreInvalidFields=true
)
public class CompanyInformationConfig {
    String name;
    String ceo;
    Integer capital;
    String address;
    String uniformNumber;
    @DateTimeFormat(pattern = "YYYY/mm/dd")
    Date createdDate;
    String description;
    String contact;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCeo() {
        return ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUniformNumber() {
        return uniformNumber;
    }

    public void setUniformNumber(String uniformNumber) {
        this.uniformNumber = uniformNumber;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setCapital(Integer capital) {
        this.capital = capital;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
