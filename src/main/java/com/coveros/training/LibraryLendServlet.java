package com.coveros.training;

import com.coveros.training.domainobjects.LibraryActionResults;
import com.coveros.training.persistence.LibraryUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.time.LocalDate;

@WebServlet(name = "LibraryLendServlet", urlPatterns = {"/lend"}, loadOnStartup = 1)
public class LibraryLendServlet extends HttpServlet {

  static Logger logger = LogManager.getLogger();
  LibraryUtils libraryUtils = new LibraryUtils();

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) {
    final String book = request.getParameter("book");
    request.setAttribute("book", book);

    final String borrower = request.getParameter("borrower");
    request.setAttribute("borrower", borrower);

    final Date now = getDateNow();
    request.setAttribute("date", now.toString());

    final LibraryActionResults libraryActionResults = libraryUtils.lendBook(book, borrower, now);

    request.setAttribute("result", libraryActionResults.toString());
    forwardToResult(request, response, logger);
  }

  /**
   * Wrapping the call to get a date for now,
   * so it's easier to stub for testing.
   */
  Date getDateNow() {
    return Date.valueOf(LocalDate.now());
  }

  /**
   * Wrapping a static method call for testing.
   */
  void forwardToResult(HttpServletRequest request, HttpServletResponse response, Logger logger) {
    ServletUtils.forwardToResult(request, response, logger);
  }
}
