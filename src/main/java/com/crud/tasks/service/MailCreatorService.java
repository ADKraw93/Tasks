package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.config.CompanyConfig;
import com.crud.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;

@Service
public class MailCreatorService {

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    private CompanyConfig companyConfig;

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    @Autowired
    private TaskRepository taskRepository;

    public String buildTrelloCardEmail(String message) {

        List<String> functionality = new ArrayList<>();
        functionality.add("You can manage your tasks");
        functionality.add("Provides connection with Trello Account");
        functionality.add("Application allows sending tasks to Trello");

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "http://localhost/tasks_frontend/");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("goodbye", "Have a nice day!");
        context.setVariable("company_name", companyConfig.getCompanyName());
        context.setVariable("company_email", companyConfig.getCompanyEmail());
        context.setVariable("company_phone", companyConfig.getCompanyPhone());
        context.setVariable("show_button", false);
        context.setVariable("is_friend", true);
        context.setVariable("admin_config", adminConfig);
        context.setVariable("application_functionality", functionality);
        return templateEngine.process("mail/created-trello-card-mail", context); //
    }

    public String buildDailyInfoEmail() {

        List<String> details = new ArrayList<>();
        details.add(companyConfig.getCompanyName());
        details.add(companyConfig.getCompanyEmail());
        details.add(companyConfig.getCompanyPhone());

        Context context = new Context();
        context.setVariable("message_many_tasks", "Currently in database you got: " + taskRepository.count() + " tasks");
        context.setVariable("message_one_task", "Currently in database you got: " + taskRepository.count() + " task");
        context.setVariable("tasks_url", "http://localhost/tasks_frontend/");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("goodbye", "Have a nice day!");
        context.setVariable("admin_config", adminConfig);
        context.setVariable("tasks_number", taskRepository.count());
        context.setVariable("company_details", details);

        /*
        boolean isMany;
        if(taskRepository.count()!=1) {
            isMany = true;
        } else {
            isMany = false;
        }

        Context context = new Context();
        context.setVariable("message", "Currently in database you got: " + taskRepository.count() + " tasks");
        context.setVariable("message_one_task", "Currently in database you got: " + taskRepository.count() + " task");
        context.setVariable("is_many", isMany); */
        return templateEngine.process("mail/daily-info-mail", context);
    }

}

