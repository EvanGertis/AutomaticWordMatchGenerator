CREATE TABLE visualization(
	id bigint(20) NOT NULL AUTO_INCREMENT,
	visualization TEXT,
	exercise_id bigint(20) NOT NULL NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY(exercise_id) REFERENCES exercise(id)
);