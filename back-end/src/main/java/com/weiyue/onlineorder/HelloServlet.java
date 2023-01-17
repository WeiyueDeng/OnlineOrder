package com.weiyue.onlineorder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weiyue.onlineorder.entity.Customer;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html");
//
//        String username = request.getParameter("username");
//
//        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1> Hello " + username + "</h1>");
//        out.println("</body></html>");

        //original data -> json send data as json
//        response.setContentType("application/json");
//        PrintWriter out = response.getWriter();
//        JSONObject obj = new JSONObject();
//        obj.put("name","Deng");
//        obj.put("email","gmail.com");
//        obj.put("age",23);
//        out.println(obj);

        //class data-> json
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        Customer customer = new Customer();
        customer.setFirstName("Cissy");
        customer.setLastName("Deng");
        customer.setEmail("gmail.com");
        customer.setPassword("0512");
        customer.setEnabled(true);

        String res = mapper.writeValueAsString(customer);
        out.println(res);

    }

    //json->java receive data from json
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject jsonRequest = new JSONObject(IOUtils.toString(request.getReader()));

        String last_name = jsonRequest.getString("last_name");
        int age = jsonRequest.getInt("age");

        System.out.println(last_name);
        System.out.println(age);

    }

    public void destroy() {
    }
}