package com.lightbend.akka.sample;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import com.lightbend.akka.sample.Printer.Greeting;

//#greeter-messages
public class Greeter extends AbstractActor {
//#greeter-messages
  static public Props props(String message, ActorRef printerActor) {
    return Props.create(Greeter.class, () -> new Greeter(message, printerActor));
  }

  //#greeter-messages
  static public class WhoToGreet {
    public final String who;
    public int count = 0;

    public WhoToGreet(String who) {
        this.who = who;
    }
  }

  static public class Greet {
    public Greet() {
    }
  }

  static public class Test {
    public Test() {
    }
  }
  //#greeter-messages

  private String message;
  private String greetingAppender = "-modified";
  private final ActorRef printerActor;
  private String greeting = "";

  public Greeter(String message, ActorRef printerActor) {
    this.message = message;
    this.printerActor = printerActor;
  }

  @Override
  public Receive createReceive() {
    return receiveBuilder()
        .match(WhoToGreet.class, wtg -> {
          this.greeting = message + ", " + wtg.who + "-" + wtg.count;
          wtg.count++;
          System.out.println(Thread.currentThread().getName() + " " + message + "-GREETER - In who to greet of " + greeting);
        }).match(Test.class, t -> {
              greeting = greeting + greetingAppender;
           System.out.println(Thread.currentThread().getName() + " " + message + "-GREETER - In test of " + greeting); })
        .match(Greet.class, x -> {
          //#greeter-send-message
          printerActor.tell(new Greeting(greeting), getSelf());
          System.out.println(Thread.currentThread().getName() + " " + message + "-GREETER - In greet of " + greeting);
          //#greeter-send-message
        })
        .build();
  }
//#greeter-messages
}
//#greeter-messages
