CREATE TABLE public.records (
	id uuid NOT NULL,
	classifier_id uuid NOT NULL,
	title varchar(500) NOT NULL,
	active bool NOT NULL DEFAULT true,
	created_at timestamp NOT NULL,
	updated_at timestamp NOT NULL,
	CONSTRAINT records_pk PRIMARY KEY (id),
	CONSTRAINT classifier_records_fk FOREIGN KEY (classifier_id) REFERENCES public.classifier(id) ON DELETE CASCADE ON UPDATE CASCADE
);