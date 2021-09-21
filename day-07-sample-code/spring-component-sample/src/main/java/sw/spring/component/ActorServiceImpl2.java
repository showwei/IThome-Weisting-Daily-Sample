package sw.spring.component;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import sw.spring.model.JohnWickMovieActor;
@Primary
@Component("ComponentChapter2")
public class ActorServiceImpl2 implements ActorService {
    @Override
    public JohnWickMovieActor getJohnWickMainActor() {
        JohnWickMovieActor johnWickMovieActor = new JohnWickMovieActor();
        johnWickMovieActor.setName("John Weisting")
                .setDescription("CEO of Killer")
                .setKillCounter(9999);
        return johnWickMovieActor;
    }

    @Override
    public JohnWickMovieActor getJohnWickHotelCEOActor() {
        JohnWickMovieActor johnWickMovieActor = new JohnWickMovieActor();
        johnWickMovieActor.setName("Winston Weisting")
                .setDescription("CEO of New York Continental Hotel ")
                .setKillCounter(0);
        return johnWickMovieActor;
    }

    @Override
    public JohnWickMovieActor getJohnWickHotelWaiterActor() {
        JohnWickMovieActor johnWickMovieActor = new JohnWickMovieActor();
        johnWickMovieActor.setName("Charon Weisting")
                .setDescription("Waiter of New York Continental Hotel ")
                .setKillCounter(77);
        return johnWickMovieActor;
    }
}
