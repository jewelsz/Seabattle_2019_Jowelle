module seabattleclient {
  requires gson;
  requires java.sql;
  requires java.logging;
  requires javafx.graphics;
  requires javafx.controls;
  requires slf4j.api;
    requires httpcore;
  requires httpclient;

  exports seabattlegui;
}