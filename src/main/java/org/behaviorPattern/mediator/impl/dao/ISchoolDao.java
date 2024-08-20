package org.behaviorPattern.mediator.impl.dao;

import org.behaviorPattern.mediator.impl.po.School;

public interface ISchoolDao {

    School querySchoolInfoById(Long treeId);

}
