CREATE TABLE public.Response
(
	id serial PRIMARY KEY,
	user_id  varchar(200),
	question_id varchar(6) NOT NULL,
	answer BOOLEAN NOT NULL,
	last_updated TIMESTAMP NOT NULL
);

CREATE TABLE public.Question
(
	id serial PRIMARY KEY,
	question_id varchar(6) NOT NULL,
	question_desc TEXT NOT NULL,
	answer BOOLEAN NOT NULL,
	created_on TIMESTAMP NOT NULL
);
