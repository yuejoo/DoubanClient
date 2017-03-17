package com.application.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloTomcat extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException
    {
  /**      // Set the response MIME type of the response message
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        // Allocate a output writer to write the response message into the network socket
        PrintWriter out = response.getWriter();

        DoubanSubjectObj book = new DoubanSubjectObj();

        try{
            DoubanBookMovieMusicService service = new DoubanBookMovieMusicService();
            book = service.getMusicInfoById(2272292);
        }
        catch(Exception e)
        {

        }

        // Write the response message, in an HTML page
        try {
            String title = book.getTitle();
            byte[] array = title.getBytes("UTF-8");
            String s = new String(array, Charset.forName("UTF-8"));

            out.println("<html>");
            out.println("<head>");
            out.println("<title>"+s+"</title></head>");

            out.println("<body>");
            out.println("<h1>" + book.getSummary() + "!</h1>");  // says Hello
            // Echo client's request information
            out.println("<p>Request URI: " + request.getRequestURI() + "</p>");
            out.println("<p>Protocol: " + request.getProtocol() + "</p>");
            out.println("<p>PathInfo: " + request.getPathInfo() + "</p>");
            out.println("<p>Remote Address: " + request.getRemoteAddr() + "</p>");
            // Generate a random number upon each request
            out.println("<p>A Random Number: <strong>" + Math.random() + "</strong></p>");
            out.println("</body></html>");
        }
        finally {
            out.close();  // Always close the output writer
        }**/
    }
}
