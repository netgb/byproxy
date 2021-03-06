package net.dongliu.byproxy.struct;

import net.dongliu.byproxy.store.Body;

import java.io.Serializable;

/**
 * WebSocket message
 *
 * @author Liu Dong
 */
public class WebSocketMessage extends Message implements Serializable {
    private static final long serialVersionUID = -6889944956935896027L;
    public static final int TYPE_TEXT = 1;
    public static final int TYPE_BINARY = 2;
    // type: 1 txt
    // type: 2 binary
    private int type;
    private boolean request;
    private volatile Body body;

    public WebSocketMessage(String host, String url, int type, boolean request) {
        super(host, url);
        this.type = type;
        this.request = request;
    }

    @Override
    public String displayText() {
        return getUrl();
    }

    public int getType() {
        return type;
    }

    public boolean isRequest() {
        return request;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }
}
