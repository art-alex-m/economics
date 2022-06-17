CREATE TABLE public.operations (
	id uuid NOT NULL,
	title varchar(500) NOT NULL,
	value double precision NOT NULL,
	"date" timestamp NOT NULL,
	updated_at timestamp NOT NULL,
	CONSTRAINT operations_pk PRIMARY KEY (id)
);
