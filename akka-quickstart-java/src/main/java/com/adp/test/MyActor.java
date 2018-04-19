package com.adp.test;

import akka.actor.AbstractLoggingActor;
import akka.actor.Props;

public class MyActor extends AbstractLoggingActor {
    static public Props props() {
        return Props.create(MyActor.class);
    }

    public MyActor(String msg) {
        log().info("Inside construcotor  argument:: " + msg);
    }

    public static Props props(String arg) {
        return Props.create(MyActor.class, arg);
    }

    public void preStart() throws Exception {
        super.preStart();
    }

    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class, s ->
                {
                    log().info("Received the string = " + s);
                }).match(Integer.class, s ->
                {
                    log().info("Received the Integer = " + s);
                }).matchAny(msg -> log().info("Undefined Message"))
                .build();
    }
}
