package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {

    /**
     * Map<String, String> vs Map<String, Object> 차이가 무엇인지??
     */
    ModelView process(Map<String, String> paramMap);

}
