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
//        HttpServer server1 = httpServer(12306);
//        server1.response("foo");
//
//        running(server1, new Runnable() {
//            @Override
//            public void run() throws IOException {
//                Content content = Request.Get("http://localhost:12306").execute().returnContent();
//                assertThat(content.asString(), is("foo"));
//            }
//        });
//    }
//}
