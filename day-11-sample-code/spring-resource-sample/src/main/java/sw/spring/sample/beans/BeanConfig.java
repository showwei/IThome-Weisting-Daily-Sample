package sw.spring.sample.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiObjectFactoryBean;
import sw.spring.sample.enums.LanguageEunm;
import sw.spring.sample.model.MovieCandidate;

import javax.annotation.PostConstruct;
import javax.naming.NamingException;
import javax.sql.DataSource;

@Configuration
public class BeanConfig {


    @Bean("MyLove")
    public MovieCandidate getMovieWedding() {
        MovieCandidate movieCandidate = new MovieCandidate();
        movieCandidate.setName("My Love");
        movieCandidate.setDescription(new StringBuffer()
                .append("是一部2021年上映的中國愛情成長片，由韓天執導")
                .append("許光漢、章若楠領銜主演，丁冠森、晏紫東、郭丞和王莎莎主演。")
                .append("電影故事改編自韓國電影《너의결혼식》，講述一段跨越十五年的愛情故事，于2021年4月30日正式上映"));
        movieCandidate.setLang(LanguageEunm.CN);
        return movieCandidate;
    }

    @Bean("GodzillaKong")
    public MovieCandidate getMovieKingKong() {
        MovieCandidate movieCandidate = new MovieCandidate();
        movieCandidate.setName("Godzilla vs. Kong");
        movieCandidate.setDescription(new StringBuffer()
                .append("是一部2021年美國科幻怪獸電影，由亞當·溫高德執導。該片為2017年電影《金剛：骷髏島》和2019電影《哥吉拉 II 怪獸之王》的續集，")
                .append("「怪獸宇宙」的第四部作品。主演包括亞歷山大·史柯斯嘉、米莉·芭比·布朗、蕾貝卡·霍爾、布萊恩·泰瑞·亨利、小栗旬、艾莎·岡薩雷、朱利安·丹尼森、凱爾·錢德勒和德米安·畢齊。")
                .append("《哥吉拉大戰金剛》由華納兄弟於2021年3月31日在美國上映，並於同日在HBO Max上線，為期一個月。亞洲部分地區提前美國一週上映。上映之後，所獲得的票房打破嚴重特殊傳染性肺炎疫情影響以來的票房記錄，同時在HBO Max得到高收視率，成為HBO Max發行的電影當中最高的一部，直到後來被《真人快打》電影超越。"));
        movieCandidate.setLang(LanguageEunm.EN);
        return movieCandidate;
    }


}
