import org.eclipse.jetty.websocket.api.Session;
import org.json.JSONObject;

import static j2html.TagCreator.*;
import static spark.Spark.init;
import static spark.Spark.webSocket;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by ricardoramos on 6/20/16.
 */
public class Chat {

    static Map<Session, String> userUsernameMap = new HashMap<>();
    static int nextUserNumber = 1; // Used for creating the next username

    public Chat(){

        webSocket("/chat", WebSocketHandler.class);
        init();
        System.out.println("\n\nWebSoket Initialized\n\n");

    }

    // Broadcast function: Admin Only
    public static void broadcastAdminMessage(String sender, String message){

        userUsernameMap.keySet().stream().filter(Session::isOpen).forEach(session -> {

            try{
                session.getRemote().sendString(String.valueOf(new JSONObject()
                        .put("userMessage", createHtmlMessageFromSender(sender, message))
                        .put("userlist", userUsernameMap.values())));
            } catch (Exception exp){
                exp.printStackTrace();
            }
        });
    }

    // Builds a HTML element with a sender-name, message, timmestamp
    private static String createHtmlMessageFromSender(String sender, String message){

        return article().with(
                b(sender + ":"),
                p(message),//colorUsernameMap.get(sender)),
                span().withClass("timestamp").withText(new SimpleDateFormat("HH:mm:ss").format(new Date()))
        ).render();
    }
}
