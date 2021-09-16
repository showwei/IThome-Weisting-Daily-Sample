package sw.idv.romp;

import sw.idv.romp.handler.ApplicationBoot;
import sw.idv.romp.handler.AutowiredHandler;
import sw.idv.romp.proxy.ObjectCloneHandler;


public class Main {

    public static void main(String[] args) {
        ApplicationBoot.getInstance().run(Main.class);
        AutowiredHandler handler = (AutowiredHandler)ObjectCloneHandler.getInstance().bind(new AutowiredHandler());
        System.out.println(handler.getTest());
    }
}
