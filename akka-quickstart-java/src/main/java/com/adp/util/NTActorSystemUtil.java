package com.adp.util;

import akka.actor.ActorSystem;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.io.File;

public class NTActorSystemUtil {

    private static ActorSystem actorSystem;

    public static void startActorSystem() {
        if (actorSystem == null) {
            Config config = ConfigFactory.load().withFallback(ConfigFactory.parseFile(new File("application.conf")));
            actorSystem = ActorSystem.create("my-actor-system", config.getConfig("my-actor-system"));
        }
        NTActorUtil.initialize();
    }

    public static void stopActorSystem() {
        if (actorSystem != null) {
            actorSystem.terminate();
        }
    }

    public static ActorSystem getActorSystem() {
        return actorSystem;
    }
}
