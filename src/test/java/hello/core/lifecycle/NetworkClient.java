package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient{
    private String url;

    public NetworkClient() {
        System.out.println("생성자호출 url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작되면 호출
    public void connect() {
        System.out.println("connect : " + url);
    }

    public void call(String message) {
        System.out.println("call : " + url + " message : " + message);
    }

    //서비스 종료시 호출
    public void disconnect() {
        System.out.println("close : " + url);
    }

    public void init() throws Exception {
        System.out.println("bean init");
        connect();
        call("초기화 연결 메세지");
    }

    //Bean method의 destroyMethod는 추론기능 (close, shutdown)이 있어서 따로 적어주지 않아도 동작함
    public void close() throws Exception {
        System.out.println("bean close");
        disconnect();
    }
}
