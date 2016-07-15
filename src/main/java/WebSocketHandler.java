/**
 * Created by ricardoramos on 6/19/16.
 */


import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

import java.io.IOException;

@WebSocket
public class WebSocketHandler {

    private String sender;
    private String message;

    @OnWebSocketConnect
    public void onConnect(Session user) throws Exception{

        String username = "User" + Chat.nextUserNumber++;
        Chat.userUsernameMap.put(user, username);
        Chat.broadcastAdminMessage(sender = "Server",  message = (username + " joined the chat"));
    }

    @OnWebSocketClose
    public void onClose(Session user, int statusCode, String reason){

        String username = Chat.userUsernameMap.get(user);
        Chat.userUsernameMap.remove(user);
        Chat.broadcastAdminMessage(sender = "Server", message = (username + " has left the chat"));
    }

    @OnWebSocketMessage
    public void onMessage(Session user, String message){

        Chat.broadcastAdminMessage(sender = Chat.userUsernameMap.get(user), this.message = message);

    }
}
