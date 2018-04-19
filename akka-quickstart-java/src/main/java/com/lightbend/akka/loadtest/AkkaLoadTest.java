package com.lightbend.akka.loadtest;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.lightbend.akka.loadtest.LoadCreator.*;

import java.io.IOException;

public class AkkaLoadTest {
    public static void main(String[] args) {
        final ActorSystem system = ActorSystem.create("helloakka");
        try {
            Props props = LoadCreator.props();
            //#create-actors
            ActorRef loadCreatorActor = system.actorOf(props, "loadCreqatorActor");
            for (int i = 1; i <= 1000; i++) {
                //#create-actors
                //#main-send-messages
                loadCreatorActor.tell(new Load(), ActorRef.noSender());
                //#main-send-messages
            }

            //System.out.println(">>> Press ENTER to exit <<<");
            System.in.read();
        } catch (IOException ioe) {
        } finally {
            system.terminate();
        }
    }
}
