package sw.spring.component;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import sw.spring.model.JohnWickMovieActor;


@Component("ComponentChapter1")
public class ActorServiceImpl implements ActorService{



    public JohnWickMovieActor getJohnWickMainActor() {
        JohnWickMovieActor johnWickMovieActor = new JohnWickMovieActor();
        johnWickMovieActor.setName("John Wick")
                            .setDescription("CEO of Killer")
                            .setKillCounter(9999);
        return johnWickMovieActor;
    }

    public JohnWickMovieActor getJohnWickHotelCEOActor() {
        JohnWickMovieActor johnWickMovieActor = new JohnWickMovieActor();
        johnWickMovieActor.setName("Winston")
                            .setDescription("CEO of New York Continental Hotel ")
                            .setKillCounter(0);
        return johnWickMovieActor;
    }

    public JohnWickMovieActor getJohnWickHotelWaiterActor() {
        JohnWickMovieActor johnWickMovieActor = new JohnWickMovieActor();
        johnWickMovieActor.setName("Charon")
                .setDescription("Waiter of New York Continental Hotel ")
                .setKillCounter(77);
        return johnWickMovieActor;
    }
}
