package com.lightbend.akka.loadtest;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class LoadCreator extends AbstractActor {

    static public Props props() {
        return Props.create(LoadCreator.class, () -> new LoadCreator());
    }

    //#load-message
    static public class Load {

    }

    private LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);
    private int count = 1;

    public LoadCreator() {
    }

    @Override
    public AbstractActor.Receive createReceive() {
        return receiveBuilder()
                .match(Load.class, loadTest -> {
                    System.out.println("LoadCreator - sleeping");
                    Thread.sleep(1000);
                    // count++ not working
                    System.out.println("LoadCreator - " + count++);
                })
                .build();
    }
}
