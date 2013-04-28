/*
CREATE TABLE snippets_framework_orm_hibernate_hibernate3_maven_plugin_o2m_a1.student (
    id MEDIUMINT NOT NULL AUTO_INCREMENT,
    name varchar(45), 
    PRIMARY KEY (id)
); 

CREATE TABLE snippets_framework_orm_hibernate_hibernate3_maven_plugin_o2m_a1.phone (
    id MEDIUMINT NOT NULL AUTO_INCREMENT,
    number varchar(45),
    PRIMARY KEY (id)
); 

CREATE TABLE snippets_framework_orm_hibernate_hibernate3_maven_plugin_o2m_a1.student_phone_map (
    id MEDIUMINT NOT NULL AUTO_INCREMENT,
    student_id MEDIUMINT NOT NULL,
    phone_id MEDIUMINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (student_id) REFERENCES student(id),
    FOREIGN KEY (phone_id) REFERENCES phone(id)
); 
*/


CREATE TABLE IF NOT EXISTS snippets_framework_orm_hibernate_hibernate3_maven_plugin_o2m_a1.student (
    id MEDIUMINT NOT NULL AUTO_INCREMENT,
    name varchar(45), 
    PRIMARY KEY (id)
); 


CREATE TABLE IF NOT EXISTS snippets_framework_orm_hibernate_hibernate3_maven_plugin_o2m_a1.phone (
    id MEDIUMINT NOT NULL AUTO_INCREMENT,
    student_id MEDIUMINT NOT NULL,
    number varchar(45),
    PRIMARY KEY (id),
    FOREIGN KEY (student_id) REFERENCES student(id) ON DELETE CASCADE ON UPDATE CASCADE
); 






