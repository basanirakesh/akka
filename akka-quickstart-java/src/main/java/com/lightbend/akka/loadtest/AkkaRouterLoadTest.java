package com.lightbend.akka.loadtest;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.adp.util.NTActorSystemUtil;
import com.adp.util.NTActorUtil;

import java.io.IOException;

public class AkkaRouterLoadTest {
    public static void main(String[] args) {
        try {
            //#create-actors
            NTActorSystemUtil.startActorSystem();
            ActorRef loadCreatorActor = NTActorUtil.getMyActorRouter();
            for (int i = 1; i <= 1000; i++) {
                //#create-actors
                //#main-send-messages
                loadCreatorActor.tell(new LoadCreator.Load(), ActorRef.noSender());
                //#main-send-messages
            }

            //System.out.println(">>> Press ENTER to exit <<<");
            System.in.read();
        } catch (IOException ioe) {
        } finally {
            NTActorSystemUtil.stopActorSystem();
        }
    }
}
