package hello.servlet.web.frontcontroller.v4;

import java.util.Map;

public interface ControllerV4 {
    //Value가 Object면 아무거나 넣을 수 있다는 뜻이다.

    /**
     *
     * @param paramMap
     * @param model
     * @return viewName
     */
    String process(Map<String, String> paramMap, Map<String, Object> model);
}
