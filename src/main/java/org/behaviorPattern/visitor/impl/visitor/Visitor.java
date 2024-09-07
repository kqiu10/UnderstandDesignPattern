package org.behaviorPattern.visitor.impl.visitor;

import org.behaviorPattern.visitor.impl.user.Student;
import org.behaviorPattern.visitor.impl.user.Teacher;

public interface Visitor {
    void visit(Student student);

    void visit(Teacher teacher);
}
