package models;

import java.util.*;
import play.data.validation.Constraints.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
public class Project extends Model {

  @Id
  public long id;

  @Required
  public String name;

  public static Finder<Long,Project> find = new Finder(
    Long.class, Project.class
  );

  public static List<Project> all() {
    return find.all();
  }

  public static void create(Project p) {
    p.save();
  }

  public static void remove(Long id) {
    find.ref(id).delete();
  }
}
