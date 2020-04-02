//package com;
//
//
//
//import java.io.IOException;
//
//import static com.github.dreamhead.moco.Moco.httpServer;
//import static com.github.dreamhead.moco.Runner.running;
//import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
//
//public class MocoTest {
//
//    @Test
//    public void should_response_as_expected() throws Exception {
//        HttpServer server = httpServer(12306);
//        server.response("foo");
//
//        running(server, new Runnable() {
//            @Override
//            public void run() throws IOException {
//                Content content = Request.Get("http://localhost:12306").execute().returnContent();
//                assertThat(content.asString(), is("foo"));
//            }
//        });
//    }
//}
