CREATE TABLE public.classifier (
	id uuid NOT NULL,
	title varchar(500) NOT NULL,
	active bool NOT NULL DEFAULT false, -- Is classifier in use
	main bool NOT NULL DEFAULT false, -- Is main classifier
	created_at timestamp NOT NULL,
	updated_at timestamp NOT NULL,
	description text NULL,
	CONSTRAINT classifier_pk PRIMARY KEY (id)
);

-- Column comments

COMMENT ON COLUMN public.classifier.active IS 'Is classifier in use';
COMMENT ON COLUMN public.classifier.main IS 'Is main classifier';