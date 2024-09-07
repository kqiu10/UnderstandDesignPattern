package org.behaviorPattern.visitor.impl.visitor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.behaviorPattern.visitor.impl.user.Student;
import org.behaviorPattern.visitor.impl.user.Teacher;

public class Parent implements Visitor {
    private static final Logger log = LogManager.getLogger();
    @Override
    public void visit(final Student student) {
        log.info("Student info name：{} clazz：{} rank：{}", student.name, student.clazz, student.ranking());
    }

    @Override
    public void visit(final Teacher teacher) {
        log.info("Teacher info name: {} clazz: {} rank: {}", teacher.name, teacher.clazz, teacher.identifier);
    }
}
