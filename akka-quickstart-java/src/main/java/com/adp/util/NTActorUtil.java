package com.adp.util;

import akka.actor.ActorRef;
import akka.routing.FromConfig;
import com.adp.test.MyActor;

public class NTActorUtil {

    private static ActorRef myActorRouter;

    public static void initialize() {
        myActorRouter = NTActorSystemUtil.getActorSystem().actorOf(FromConfig.getInstance()
                .props(MyActor.props("test")), "myActorRouter");
    }

    public static ActorRef getMyActorRouter() {
        return myActorRouter;
    }
}