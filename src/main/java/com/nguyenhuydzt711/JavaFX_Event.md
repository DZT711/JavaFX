# JavaFX Events

## Overview

An event notifies that something important has taken place. Events are typically the "primitive" of an event system (aka event bus). Generally, an event system has the following 3 responsibilities:

1. **Fire** (trigger) an event
2. **Notify** listeners (interested parties) about the event
3. **Handle** (process) the event

The event notification mechanism is done by the JavaFX platform automatically. Hence, we will only consider how to fire events, listen for events and how to handle them.

## Custom Event Creation

First, let's create a custom event:

```java
public static final EventType<UserEvent> ANY = new EventType<>(EventType.ANY, "ANY");   
public static final EventType<UserEvent> LOGIN_SUCCEEDED = new EventType<>(ANY, "LOGIN_SUCCEEDED");
public static final EventType<UserEvent> LOGIN_FAILED = new EventType<>(ANY, "LOGIN_FAILED");

public userEvent(EventType<? extends Event> eventType) {
    super(eventType);
}
```

Since event types are fixed, they are usually created within the same source file as the event. We can see that there are 2 specific types of events: `LOGIN_SUCCEEDED` and `LOGIN_FAILED`.

### Listening for Specific Event Types

We can listen for such specific types of events:

```java
Node node = ...
node.addEventHandler(UserEvent.LOGIN_SUCCEEDED, event -> {
    // handle event
});
```

Alternatively, we can handle any `UserEvent`:

```java
Node node = ...
node.addEventHandler(UserEvent.ANY, event -> {
    // handle event
});
```

### Firing Custom Events

Finally, we are able to construct and fire our own events:

```java
UserEvent event = new UserEvent(UserEvent.LOGIN_SUCCEEDED);
Node node = ...
node.fireEvent(event);
```

## Input Events

Key and mouse events are the most common types of events used in JavaFX. Each Node provides so-called "convenience methods" for handling these events. For instance, we can run some code when a button is pressed:

```java
Button button = ...
button.setOnAction(event -> {
    // button was pressed
});
```

For more flexibility we can also use the following:

```java
Button button = ...
button.setOnMouseEntered(e -> ...);
button.setOnMouseExited(e -> ...);
button.setOnMousePressed(e -> ...);
button.setOnMouseReleased(e -> ...);
```

The object `e` above is of type `MouseEvent` and can be queried to obtain various information about the event, e.g. x and y positions, number of clicks, etc. Finally, we can do the same with keys:

```java
Button button = ...
button.setOnKeyPressed(e -> ...);
button.setOnKeyReleased(e -> ...);
```

The object `e` here is of type `KeyEvent` and it carries information about the key code, which can then be mapped to a real physical key on the keyboard.
