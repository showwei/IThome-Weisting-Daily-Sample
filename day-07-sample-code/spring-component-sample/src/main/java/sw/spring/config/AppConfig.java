package sw.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sw.spring.component.ActorService;
import sw.spring.component.ActorServiceImpl;
import sw.spring.component.ActorServiceImpl2;
import sw.spring.model.JohnWickMovieActor;

@Configuration
public class AppConfig {

    @Bean("Chapter-1")
    public ActorService getActorServiceChapter1() {
        return new ActorServiceImpl() {
            @Override
            public JohnWickMovieActor getJohnWickMainActor() {
                JohnWickMovieActor johnWickMovieActor = new JohnWickMovieActor();
                johnWickMovieActor.setName("John Wick2222")
                        .setDescription("CEO of Killer22222")
                        .setKillCounter(8888);
                return johnWickMovieActor;
            }
        };
    }

    @Bean("Chapter-2")
    public ActorService getActorServicChapter2() {
        return new ActorServiceImpl2();
    }
}
