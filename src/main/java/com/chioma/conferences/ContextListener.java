package com.chioma.conferences;

import com.chioma.conferences.db.UserDao;
import com.chioma.conferences.entities.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.concurrent.atomic.AtomicReference;

public class ContextListener implements ServletContextListener {

    private AtomicReference<UserDao> dao;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        dao = new AtomicReference<>(new UserDao());

        dao.get().add(new User(1, "Esta", "hello1", User.ROLE.ADMIN));
        dao.get().add(new User(2, "Katia", "hello2", User.ROLE.USER));

        final ServletContext servletContext =
                servletContextEvent.getServletContext();

        servletContext.setAttribute("dao", dao);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        dao = null;
    }
}
