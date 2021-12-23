package hello.servlet.web.frontcontroller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class MyView {
    private String viewPath;

    public MyView(String viewPath) {
        this.viewPath = viewPath;
    }

    //jsp로 이동하는것을 렌더링 이라고 한다. (view를 만드는 행위)

    public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }

    /**
     * HttpServletRequest : 데이터를 컨트롤러로 보낼때 데이터가 저장되는 객체
     * 원하는 데이터를 꺼낼때는 String 타입으로 반환하는 .getParameter() 메서드를 이용한다.
     * HttpServletResponse: 클라이언트에 데이터를 전송하기 위해 사용
     */

    public void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        modelToRequestAttribute(model, request);
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);

    }

    /**
     * Map<String, Object> map = HashMap<>();
     * Map은 인터페이스 이기 때문 선언만 가능하고 객체 생성 불가. 그래서 자식인 HashMap으로 객체 생성
     * HashMap<String, Object> map2 = HashMap<>(); 도 가능
     * List와 ArrayList도 같은 맥락이다.
     * HashMap은 순서를 보장하지 않는다.
     *
     * Map: Key와 Value로 이루어진 데이터의 집합. 구현클래스 -> Hashtable, HashMap, SortedMap
     */

    private void modelToRequestAttribute(Map<String, Object> model, HttpServletRequest request) {
        model.forEach((key, value) -> request.setAttribute(key, value));
    }

    /**
     * forEach(변수 -> 반복처리(변수))
     * (key, value)에 model에 저장되어있는 값을 하나씩 대입한다.
     * 그리고 출력문인 request.setAttribute에서 이것을 받아 request에 저장한다.
     */

    /**
     * 람다식: 식별자없이 실행가능한 함수
     * (매개변수, ...) -> {실행문 ...}
     * 매개변수의 값을 이용해 {}바디를 실행한다.
     */
}
