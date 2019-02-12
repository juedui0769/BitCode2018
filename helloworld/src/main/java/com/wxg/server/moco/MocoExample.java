package com.wxg.server.moco;

import org.junit.Test;
import java.io.IOException;
import com.github.dreamhead.moco.HttpServer;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import com.github.dreamhead.moco.Runnable;

import static com.github.dreamhead.moco.Moco.*;
import static com.github.dreamhead.moco.Runner.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MocoExample {

    @Test
    public void should_response_as_expected() throws Exception {
        HttpServer server = httpServer(12306);
        server.response("foo");

        running(server, new Runnable() {
            @Override
            public void run() throws IOException {
                Content content = Request.Get("http://localhost:12306").execute().returnContent();
                assertThat(content.asString(), is("foo"));
            }
        });
    }
}
