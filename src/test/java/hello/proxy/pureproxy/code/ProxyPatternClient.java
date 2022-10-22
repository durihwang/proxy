package hello.proxy.pureproxy.code;

import lombok.RequiredArgsConstructor;

public class ProxyPatternClient {

    private Subject subject;

    public ProxyPatternClient(Subject subject) {
        this.subject = subject;
    }

    public void execute() {
        subject.operation();
    }

}
