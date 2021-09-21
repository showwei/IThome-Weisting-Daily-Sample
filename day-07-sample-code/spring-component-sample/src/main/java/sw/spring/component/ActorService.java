package sw.spring.component;

import sw.spring.model.JohnWickMovieActor;

public interface ActorService {
    JohnWickMovieActor getJohnWickMainActor();
    JohnWickMovieActor getJohnWickHotelCEOActor();
    JohnWickMovieActor getJohnWickHotelWaiterActor();
}
