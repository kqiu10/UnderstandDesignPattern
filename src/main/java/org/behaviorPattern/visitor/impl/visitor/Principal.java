package org.behaviorPattern.visitor.impl.visitor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.behaviorPattern.visitor.impl.user.Student;
import org.behaviorPattern.visitor.impl.user.Teacher;

public class Principal implements Visitor {

    private static final Logger log = LogManager.getLogger();
    @Override
    public void visit(final Student student) {
        log.info("Student info clazz：{} count：{}", student.clazz, student.count());
    }

    @Override
    public void visit(final Teacher teacher) {
        log.info("Teacher info clazz: {} : {}", teacher.clazz, teacher.entranceRatio());
    }
}
