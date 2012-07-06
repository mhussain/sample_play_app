package controllers;

import play.*;
import play.data.*;
import play.mvc.*;
import models.*;

import views.html.*;

public class Application extends Controller {

  static Form<Project> projectForm = form(Project.class);

  public static Result index() {
    return redirect(routes.Application.projects());
    //return ok("Did this work ? I dont know.");
  }

  public static Result removeProject(Long id) {
    Project.remove(id);
    return redirect(routes.Application.projects());
  }

  public static Result createProject() {
    Form<Project> filledForm = projectForm.bindFromRequest();
    if(filledForm.hasErrors()) {
      return badRequest(
        views.html.index.render(Project.all(), filledForm)
      );
    }
    else {
      Project.create(filledForm.get());
      return redirect(routes.Application.projects());
    }
  }

  public static Result projects() {
    return ok(
      views.html.index.render(
        Project.all(),
        projectForm
      )
    );
  }
}
